package atariBreakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by snyder on 2015-12-17.
 */
public class Box extends JFrame {
    private final Block block;
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final ArrayList<Image> images = new ArrayList<>();
    long score = 0;
    private static final Random r = new Random();
    private final Label l = new Label("Game starting in 1");
    private final ActionListener controller;

    Box(ActionListener controller) {
        super("Atari Breakout");
        this.controller = controller;
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
        setBounds(0, 0, 800, 800);
        //setBackground(getBackground());

        block = new Block(0, 825, 400, 10);
        GamePanel gp = new GamePanel(block, balls, images);
        Thread t = new Thread(new Baller(this, block, balls, images));

        gp.add(l);

        for (int i = 5; i <= 11; i++) {
            for (int j = 1; j <= 24; j++) {
                Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                Image img = new Image(j * 50, i * 50, 50, 50, c);
                img.setDoubleBuffered(true);
                images.add(img);
                gp.add(img);
            }
        }
        for (int i = 0; i < 2; i++) {
            Ball ball = new Ball(r.nextInt(500), getHeight() - (3 - i) * 100, 20);
            balls.add(ball);
        }

        addMouseMotionListener(new BreakoutMouseListener(block));
        addKeyListener(new BreakoutKeyListener(block));

        add(gp);

        setFocusable(true);
        setVisible(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        block.resetRotation();
        t.start();
    }

    public void increaseScore() {
        score += 10;
        l.setText("Score: " + String.valueOf(score));
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Control");

        menuBar.add(menu);
        menu.setBackground(Color.BLUE);

        JMenuItem menuItem = new JMenuItem("Save Progress", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This save the progress of the game. ");
        menu.add(menuItem);

        menuItem = new JMenuItem("Pause/Resume", KeyEvent.VK_SPACE);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(' '));
        menuItem.getAccessibleContext().setAccessibleDescription("This save the progress of the game. ");
        menuItem.addActionListener(controller);
        menu.add(menuItem);
        menuBar.add(menu);

        return menuBar;
    }
}
