package atariBreakout;

import java.awt.event.*;

public class Controller implements ActionListener {
    boolean paused = false;

    public void startGame() {
        Box box = new Box(this);
        box.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Space pressed. ");
        paused = !paused;
    }

}