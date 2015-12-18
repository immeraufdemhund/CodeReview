package stackpanel;

import javax.swing.*;

/**
 * Created by snyder on 2015-09-30.
 */
public class VerticalButtons {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager
                        .getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();

        frame.getContentPane().add(createVerticalButtons());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    private static JComponent createVerticalButtons() {

        VerticalPanel buttons = new VerticalPanel(2);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        buttons.add(b1);
        buttons.add(b2);

        return buttons;
    }
}
