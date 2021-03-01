package listeners;

import main.Ball;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.Constants.*;

public class MouseLsnr extends MouseAdapter {

    ArrayList<Ball> balls;
    Random colorGenerator = new Random();
    ExecutorService threadExecutor;
    Color ballColor;
    Integer numBalls = 0;
    Random random;

    public MouseLsnr(ArrayList<Ball> balls) {
        this.balls = balls;
        random = new Random();
        threadExecutor = Executors.newCachedThreadPool();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        createBall(e.getX(), e.getY());
        numBalls = balls.size();
    }

    public void createBall(double x, double y) {
        ballColor = new Color(colorGenerator.nextInt(255), colorGenerator.nextInt(255), colorGenerator.nextInt(255));
        int maxRadius = (Math.min(PANEL_WIDTH, PANEL_HEIGHT) / 8);
        int speedX = (PANEL_HEIGHT/ 24);
        int speedY = (PANEL_WIDTH / 24);
        balls.add(new Ball(x, y, random.nextInt(maxRadius) + 1, (random.nextInt(speedX * 2)) + 1 - speedX, (random.nextInt(speedY * 2)) + 1 - speedY, ballColor));
        threadExecutor.execute(balls.get(balls.size() - 1));
    }
}
