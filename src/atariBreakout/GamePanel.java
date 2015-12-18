package atariBreakout;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Block block;
    private final Iterable<? extends Ball> balls;
    private final Iterable<? extends Image> images;
    private java.awt.Image OSC;

    public GamePanel(Block block, Iterable<? extends Ball> balls, Iterable<? extends Image> images) {
        this.block = block;
        this.balls = balls;
        this.images = images;
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        checkOffscreenImage();
        Graphics offG = OSC.getGraphics();
        offG.setColor(Color.white);
        offG.fillRect(0, 0, d.width, d.height);
        paintSprites(OSC.getGraphics());
        g.drawImage(OSC, 0, 0, null);

    }

    private void checkOffscreenImage() {
        Dimension d = getSize();
        if (OSC == null || OSC.getWidth(null) != d.width
                || OSC.getHeight(null) != d.height) {
            OSC = createImage(d.width, d.height);
        }
    }

    public void paintSprites(Graphics g) {
        block.paint(g);
        for (Ball ball : balls) {
            ball.drawSprite((Graphics2D)g);
        }
        for (Image img : images) {
            img.paint(g);
        }
    }
}

