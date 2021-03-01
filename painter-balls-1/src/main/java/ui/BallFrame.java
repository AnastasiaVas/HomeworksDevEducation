package ui;

import javax.swing.*;
import java.awt.*;
import static utils.Constants.PANEL_NAME;

public class BallFrame {

    BallPanel b;
    JFrame f;

    public BallFrame(){
        b = new BallPanel();
        f = new JFrame(PANEL_NAME);
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.add( b );
        f.setBackground(Color.BLACK);
        f.pack();
        f.setVisible(true);
        f.setResizable(false);
        while(true)
        {
            f.repaint();
            b.moveBall();
            try
            {
                Thread.sleep(10);
            }
            catch(Exception event){}
        }
    }
}