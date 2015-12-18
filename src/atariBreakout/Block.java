package atariBreakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Block extends JPanel{
    public int x;
    public int y;
    public int length;
    public int width;
    private int degrees;
    private static final int ROTATION = 5;

    Block(int x, int y, int length, int width){
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        setBackground(Color.blue);

        setDoubleBuffered(true);
    }

    public int getDegrees(){
        return degrees;
    }

    public void rotateRight(){
        rotate(-ROTATION);
    }

    public void rotateLeft(){
        rotate(ROTATION);
    }

    public void resetRotation() {
        rotate(-degrees);
    }

    public void moveTo(int x) {
        this.x = x - length / 2;
        repaint();
    }

    private void rotate(int amount){
        degrees += amount;
        if (degrees == 180)
            degrees = 0;
        if(degrees >= 180)
            degrees -= 180;
        repaint();
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(-Math.toRadians(degrees), x+this.length/2, y+this.width/2);
        g2.setColor(getBackground());
        g2.fillRect(this.x, this.y, this.length, this.width);
        g2.rotate(+Math.toRadians(degrees), x+this.length/2, y+this.width/2);
    }
}