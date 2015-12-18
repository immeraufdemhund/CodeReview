package atariBreakout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BreakoutMouseListener extends MouseMotionAdapter {
    private final Block block;

    BreakoutMouseListener(Block block) {
        this.block = block;
    }

    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        block.moveTo(x);
    }
}
