package atariBreakout;

import java.awt.*;

public class Baller implements Runnable {
    private final Box box;
    private final Block block;
    private final Iterable<? extends Ball> balls;
    private final Iterable<? extends Image> images;
    private boolean paused;

    public Baller(Box box, Block block, Iterable<? extends Ball> balls, Iterable<? extends Image> images) {
        this.box = box;
        this.block = block;
        this.balls = balls;
        this.images = images;
    }

    public void playPause(){
        paused = !paused;
    }

    @Override
    public void run() {
        wait(1000);
        updateGame();
    }

    private void updateGame(){
        while (true) {
            wait(10);
            for (Ball ball : balls) {
                if (updateBallPosition(ball)) break;
            }
            box.repaint();
        }
    }

    private boolean updateBallPosition(Ball ball) {
        int velocity = ball.velocity;
        if (paused)
            ball.velocity = 0;
        else
            ball.velocity = velocity;

        Rectangle b = ball.getBounds();
        Rectangle blockr = new Rectangle(block.x, block.y, block.length, block.width);
        if (b.intersects(blockr) && !ball.touchedLast) {
            if (block.getDegrees() >= 0)
                ball.xDegrees = 2 * block.getDegrees() - ball.xDegrees;
            else if (block.getDegrees() < 0)
                ball.xDegrees = -ball.xDegrees + 2 * block.getDegrees();
            ball.blockTime = System.currentTimeMillis();
            ball.touchedLast = true;
        } else if (!b.intersects(blockr) && ball.touchedLast && System.currentTimeMillis() - ball.blockTime >= 700) {
            ball.touchedLast = false;
        }

        if (b.x <= 0) {
            if (ball.xDegrees > 0)
                ball.xDegrees = 180 - ball.xDegrees;
            else
                ball.xDegrees = -180 - ball.xDegrees;
        }
        if (b.y <= 10) {
            ball.xDegrees *= -1;
        }
        if (b.x >= box.getWidth() - 80) {
            if (ball.xDegrees < 0)
                ball.xDegrees = -180 - ball.xDegrees;
            else
                ball.xDegrees = 180 - ball.xDegrees;
        }
        if (b.y >= box.getHeight() - 100) {
            System.out.println("You died");
            return true;
        }
        double ballXCalc = Math.cos(Math.toRadians(ball.xDegrees)) * ball.velocity;
        double ballYCalc = Math.sin(Math.toRadians(ball.xDegrees)) * ball.velocity;
        if (ball.xDegrees >= 0) {
            if (ball.xDegrees < 90) {
                ball.translate(ballXCalc, -ballYCalc);
            } else if (ball.xDegrees == 180) {
                ball.translate(-ball.velocity, 0);
            } else if (ball.xDegrees > 90) {
                ball.translate(ballXCalc, -ballYCalc);
            } else if (ball.xDegrees == 90) {
                ball.translate(0, -ball.velocity);
            }
        } else if (ball.xDegrees < 0) {
            if (ball.xDegrees > -90) {
                ball.translate(ballXCalc, -ballYCalc);
            } else if (ball.xDegrees < -90) {
                ball.translate(ballXCalc, -ballYCalc);
            } else if (ball.xDegrees == -90) {
                ball.translate(0, ball.velocity);
            }
        }

        for (Image img : images) {
            checkIfBallTouchesImage(ball, b, img);
        }
        return false;
    }

    private void checkIfBallTouchesImage(Ball ball, Rectangle b, Image img) {
        Rectangle r = new Rectangle(img.x, img.y,
                img.length, img.width);
        if (b.intersects(r) && !ball.touchedImage) {
            img.width = 0;
            img.length = 0;
            ball.xDegrees *= -1;
            box.increaseScore();
        }
    }

    private void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}