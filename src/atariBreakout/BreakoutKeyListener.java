package atariBreakout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by snyder on 2015-12-17.
 */
public class BreakoutKeyListener extends KeyAdapter {
    private final Block block;

    BreakoutKeyListener(Block block) {
        this.block = block;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            block.rotateLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            block.rotateRight();
        }
    }
}
