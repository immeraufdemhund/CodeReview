import atariBreakout.Controller;

import javax.swing.*;

/**
 * Created by snyder on 2015-12-17.
 */
public class Program {

    public static void main(String[] args) {
        makeWindowNativeLooking();
        Controller c = new Controller();
        c.startGame();
        System.out.println("Game Started...");
    }

    private static void makeWindowNativeLooking() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
