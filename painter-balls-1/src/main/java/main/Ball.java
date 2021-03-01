package main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;


public class Ball implements Runnable {
    Ellipse2D.Double ball; // main.Ball objects shape attributes
    Dimension ballDimension; // Store size of a main.Ball
    Point2D.Double ballCoords; // Store location coords of a main.Ball
    Point2D.Double ballVelocity; // Store x and y velocity of main.Ball
    final Color colorOfBall; // Store randomized color of ball
    static final Point2D.Double xBoundaries = new Point2D.Double(0, 600); // Horizontal boundaries of a ball
    static final Point2D.Double yBoundaries = new Point2D.Double(0, 440); // Vertical boundaries of a ball
    final Random initialDirection = new Random();  // Randomize ball's initial left|right direction
    float speedX;
    float speedY;
    float radius;

    public Ball(double xPos, double yPos, int radius, float speedX, float speedY, Color ballColor) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.radius = radius;
        ballCoords = new Point2D.Double(xPos, yPos);
        ballDimension = new Dimension( radius, radius);
        ballVelocity = new Point2D.Double(speedX, speedY);
        colorOfBall = ballColor; //
        setBallObject(ballCoords, ballDimension);
    }

    @Override
    public void run() {
        while (true) {
            updateBallPosition();

            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }
    }

    public void updateBallPosition() {
        if (ballCoords.getX()+radius >= (640 - speedX)) {
            ballCoords.setLocation(640-radius, ballCoords.getY() + speedY);
            speedX = -speedX;
        } else if (ballCoords.getX()-radius <= speedX && speedX < 0){
            ballCoords.setLocation(0, ballCoords.getY() + speedY);
            speedX = -speedX;
        } else if (ballCoords.getY()+radius >= (480 - speedY)){
            ballCoords.setLocation(ballCoords.getX() + speedX, 480-radius);
            speedY = -speedY;
        } else if (ballCoords.getY()-radius <= speedY && speedY < 0){
            ballCoords.setLocation(ballCoords.getX() + speedX, 0);
            speedY = -speedY;
        } else {
            ballCoords.setLocation(ballCoords.getX() + speedX, ballCoords.getY() + speedY);
        }


        setBallObject(ballCoords);

    }

    private void setBallObject(Point2D loc, Dimension size) {
        ball = new Ellipse2D.Double(loc.getX(), loc.getY(), size.getWidth(), size.getHeight());
    }

    private void setBallObject(Point2D loc) {
        ball.setFrame(loc, ballDimension);
    }

    public Ellipse2D.Double getBallObject() {
        return ball;
    }

    public Point2D getBallVelocity() {
        return ballVelocity;
    }

    public Point2D getBallCoords() {
        return ballCoords;
    }

    public Color getBallColor() {
        return colorOfBall;
    }

    public Dimension getBallDimension() {
        return ballDimension;
    }

}
