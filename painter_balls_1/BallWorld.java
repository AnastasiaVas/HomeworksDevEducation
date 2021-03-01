import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.event.*;
/**
 * The control logic and main display panel for game.
 * 
 * @author Hock-Chuan Chua
 * @version October 2010
 */
public class BallWorld extends JPanel {
   private static final int UPDATE_RATE = 30;    // Frames per second (fps)
   private static final float EPSILON_TIME = 1e-2f;  // Threshold for zero time
   ExecutorService threadExecutor;

   Random random = new Random();
   // Balls
   private int currentNumBalls;             // Number currently active
   private ArrayList<Ball> balls = new ArrayList<Ball>();

   private ContainerBox box;     // The container rectangular box
   private DrawCanvas canvas;    // The Custom canvas for drawing the box/ball
   private int canvasWidth;
   private int canvasHeight;

   private ControlPanel control; // The control panel of buttons and sliders.  
   private boolean paused = false;  // Flag for pause/resume control
   
   /**
    * Constructor to create the UI components and init the game objects.
    * Set the drawing canvas to fill the screen (given its width and height).
    * 
    * @param width : screen width
    * @param height : screen height
    */
   public BallWorld(int width, int height) {
      final int controlHeight = 30;    
      canvasWidth = width;
      canvasHeight = height - controlHeight;  // Leave space for the control panel
      
      // Init the balls
//      currentNumBalls = 2;
//      balls[0] = new Ball(300, 100, 25, 5, 90, Color.YELLOW);
//      balls[1] = new Ball(300, 300, 100, 6, -90, Color.YELLOW);

//      currentNumBalls = 5;  // 2 vertical balls
//      balls[0] = new Ball(300, 100, 25, -5, 90, Color.GREEN);
//      balls[1] = new Ball(300, 200, 25, 6, 90, Color.YELLOW);
//      balls[2] = new Ball(300, 370, 25, -1, 90, Color.CYAN);
//      balls[3] = new Ball(300, 370, 25, 4, 90, Color.PINK);
//      balls[4] = new Ball(300, 450, 25, -3, 90, Color.MAGENTA);

//        // Error here, balls run across each other, need to write log to check the program.
//        currentNumBalls = 5;  // horizontal balls
//        balls[0] = new Ball(100, 300, 25, -5, 0, Color.GREEN);
//        balls[1] = new Ball(200, 300, 25, 6, 0, Color.YELLOW);
//        balls[2] = new Ball(330, 300, 25, -1, 0, Color.CYAN);
//        balls[3] = new Ball(400, 300, 25, 4, 0, Color.PINK);
//        balls[4] = new Ball(550, 300, 25, -3, 0, Color.MAGENTA);

      currentNumBalls = 0;
      threadExecutor = Executors.newCachedThreadPool();
   //   // The rest of the balls, that can be launched using the launch button
   //   for (int i = currentNumBalls; i < MAX_BALLS; i++) {
   //      // Allocate the balls, but position later before the launch
   //      balls[i] = new Ball(20, canvasHeight - 20, 15, 5, 45, Color.RED);
   //   }
   
      // Init the Container Box to fill the screen
      box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

      // Init the custom drawing panel for drawing the game
      canvas = new DrawCanvas();

      // Init the control panel
      control = new ControlPanel();
   
      // Layout the drawing panel and control panel
      this.setLayout(new BorderLayout());
      this.add(canvas, BorderLayout.CENTER);
      this.add(control, BorderLayout.SOUTH);
      
      // Handling window resize. Adjust container box to fill the screen.
      this.addComponentListener(new ComponentAdapter() {
         // Called back for first display and subsequent window resize.
         @Override
         public void componentResized(ComponentEvent e) {
            Component c = (Component)e.getSource();
            Dimension dim = c.getSize();
            canvasWidth = dim.width;
            canvasHeight = dim.height - controlHeight; // Leave space for control panel
            // Need to resize all components that is sensitive to the screen size.
            box.set(0, 0, canvasWidth, canvasHeight);
         }
      });

      addMouseListener(
              new MouseAdapter()
              {
                 @Override
                 public void mouseClicked( MouseEvent e )
                 {
              //      float maxRadius = (float) (Math.min(canvasWidth, canvasHeight))/8;
              //      float speedX = (float) (canvasHeight / 6);
              //      float speedY = (float) (canvasWidth / 6);
              //      balls[currentNumBalls] = new Ball(e.getX(), e.getY(), random.nextFloat()*maxRadius, random.nextFloat()*speedX, random.nextFloat()*speedY, random.nextInt(360)+1, Color.CYAN);


                    int maxRadius = (Math.min(canvasWidth, canvasHeight))/8;
                    int speedX = (canvasHeight / 24);
                    int speedY = (canvasWidth / 24);
                    balls.add(new Ball(e.getX(), e.getY(), random.nextInt(maxRadius)+1, random.nextInt(speedX)+1, random.nextInt(speedY)+1, Color.CYAN));
                    threadExecutor.execute( balls.get(balls.size() - 1) );
                    currentNumBalls++;
                    transferFocusUpCycle();  // To handle key events
                 } // end mouseClicked

              } // end MouseAdapter()
      ); // End anonymous inner class
      // Start the ball bouncing
   //   gameStart();
   }
   
   /** Start the ball bouncing. */
 //  public void gameStart() {
 //     // Run the game logic in its own thread.
 //     Thread gameThread = new Thread() {
 //        public void run() {
 //           while (true) {
 //              long beginTimeMillis, timeTakenMillis, timeLeftMillis;
 //              beginTimeMillis = System.currentTimeMillis();
 //
 //              if (!paused) {
 //                 // Execute one game step
 //                 gameUpdate();
 //                 // Refresh the display
 //                 repaint();
 //              }
 //
 //              // Provide the necessary delay to meet the target rate
 //              timeTakenMillis = System.currentTimeMillis() - beginTimeMillis;
 //              timeLeftMillis = 1000L / UPDATE_RATE - timeTakenMillis;
 //              if (timeLeftMillis < 5) timeLeftMillis = 5; // Set a minimum
 //
 //              // Delay and give other thread a chance
 //              try {
 //                 Thread.sleep(timeLeftMillis);
 //              } catch (InterruptedException ex) {}
 //           }
 //        }
 //     };
 //     gameThread.start();  // Invoke GaemThread.run()
 //  }
   
   /** 
    * One game time-step. 
    * Update the game objects, with proper collision detection and response.
    */
   public void gameUpdate() {
      float timeLeft = 1.0f;  // One time-step to begin with
      
      // Repeat until the one time-step is up 
      do {
         // Find the earliest collision up to timeLeft among all objects
         float tMin = timeLeft;
         
         // Check collision between two balls
         for (int i = 0; i < currentNumBalls; i++) {
            for (int j = 0; j < currentNumBalls; j++) {
               if (i < j) {
                  balls.get(i).intersect(balls.get(j), tMin);
                  if (balls.get(i).earliestCollisionResponse.t < tMin) {
                     tMin = balls.get(i).earliestCollisionResponse.t;
                  }
               }
            }
         }
         // Check collision between the balls and the box
         for (int i = 0; i < currentNumBalls; i++) {
            balls.get(i).intersect(box, tMin);
            if (balls.get(i).earliestCollisionResponse.t < tMin) {
               tMin = balls.get(i).earliestCollisionResponse.t;
            }
         }
   
         // Update all the balls up to the detected earliest collision time tMin,
         // or timeLeft if there is no collision.
    //     for (int i = 0; i < currentNumBalls; i++) {
    //        balls[i].update(tMin);
    //     }
   
         timeLeft -= tMin;                // Subtract the time consumed and repeat
      } while (timeLeft > EPSILON_TIME);  // Ignore remaining time less than threshold
   }

   /** The custom drawing panel for the bouncing ball (inner class). */
   class DrawCanvas extends JPanel {
      /** Custom drawing codes */
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);    // Paint background
         // Draw the balls and box
         box.draw(g);
         for (int i = 0; i < currentNumBalls; i++) {
            balls.get(i).draw(g);
         }
         // Display balls' information
         g.setColor(Color.WHITE);
         g.setFont(new Font("Courier New", Font.PLAIN, 12));
      }

      /** Called back to get the preferred size of the component. */
      @Override
      public Dimension getPreferredSize() {
         return (new Dimension(canvasWidth, canvasHeight));
      }
   }
   
   /** The control panel (inner class). */
   class ControlPanel extends JPanel {
   
      /** Constructor to initialize UI components of the controls */
      public ControlPanel() {
         // A checkbox to toggle pause/resume movement
         JCheckBox pauseControl = new JCheckBox();
         this.add(new JLabel("Pause"));
         this.add(pauseControl);
         pauseControl.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               paused = !paused;  // Toggle pause/resume flag
               transferFocusUpCycle();  // To handle key events
            }
         });

         // A slider for adjusting the speed of all the balls by a factor
         final float[] ballSavedSpeedXs = new float[25];
         final float[] ballSavedSpeedYs = new float[25];
         for (int i = 0; i < currentNumBalls; i++) {
            ballSavedSpeedXs[i] = balls.get(i).speedX;
            ballSavedSpeedYs[i] = balls.get(i).speedY;
         }
         int minFactor = 5;    // percent
         int maxFactor = 200;  // percent
         JSlider speedControl = new JSlider(JSlider.HORIZONTAL, minFactor, maxFactor, 100);
         this.add(new JLabel("Speed"));
         this.add(speedControl);
         speedControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               JSlider source = (JSlider)e.getSource();
               if (!source.getValueIsAdjusting()) {
                  int percentage = (int)source.getValue();
                  for (int i = 0; i < currentNumBalls; i++) {
                     balls.get(i).speedX = ballSavedSpeedXs[i] * percentage / 100.0f;
                     balls.get(i).speedY = ballSavedSpeedYs[i] * percentage / 100.0f;
                  }
               }
               transferFocusUpCycle();  // To handle key events
            }
         });

         // A button for launching the remaining balls
         final JButton launchControl = new JButton("Launch New Ball");
         this.add(launchControl);
         launchControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  balls.get(currentNumBalls).x = 20;
                  balls.get(currentNumBalls).y = canvasHeight - 20;
                  currentNumBalls++;
               transferFocusUpCycle();  // To handle key events
            }
         });

         addMouseListener(
                 new MouseAdapter()
                 {
                    @Override
                    public void mouseClicked( MouseEvent e )
                    {
                       balls.get(currentNumBalls).x = e.getX();
                       balls.get(currentNumBalls).y = e.getY();

                       currentNumBalls++;
                       transferFocusUpCycle();  // To handle key events
                    } // end mouseClicked

                 } // end MouseAdapter()
         ); // End anonymous inner class
      }
   }
}
