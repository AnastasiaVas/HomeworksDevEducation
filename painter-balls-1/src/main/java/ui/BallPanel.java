package ui;

import listeners.MouseLsnr;
import main.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static utils.Constants.*;

class BallPanel extends JPanel {
    private ArrayList<Ball> balls;
    private MouseAdapter mouseLsnr;

    public BallPanel() {
        balls = new ArrayList();
        mouseLsnr = new MouseLsnr(balls);
        addMouseListener(mouseLsnr);
    }


    public void moveBall() {
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Ball ball : balls) {
            g2d.setPaint(ball.getBallColor());
            g2d.fillOval((int) ball.getBallCoords().getX(), (int) ball.getBallCoords().getY(), (int) ball.getBallDimension().getWidth(), (int) ball.getBallDimension().getHeight());
        }

    }
}
