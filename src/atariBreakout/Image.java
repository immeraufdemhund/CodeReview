package atariBreakout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Image extends JPanel{
    public int x;
    public int y;
    public int length;
    public int width;
    public Color color;
    public Image(int x, int y, int length, int width, Color color){
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(this.color);
        g.fillRect(x, y, length, width);
    }
    public boolean equals(Object o){
        if(o instanceof Image){
            Image img = (Image) o;
            if(img.x == this.x && img.y == this.y) return true;
            else return false;
        } else return false;
    }
}
