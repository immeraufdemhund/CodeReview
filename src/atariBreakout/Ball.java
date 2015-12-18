package atariBreakout;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Ball extends Sprite{
    public int radius;
    public int velocity;
    public double yDir;
    public double xDegrees;
    public boolean touchedLast = false;
    public boolean touchedImage = false;
    public long blockTime;
    private final AffineTransform transform = new AffineTransform();

    public Ball(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.velocity = 0;
        this.yDir = 1;
        this.xDegrees = -90;
        spriteShape = new Ellipse2D.Double(x, y, radius, radius);
    }

    @Override
    public void drawSprite(Graphics2D g) {
        System.out.println("B: " + getBounds());
        spriteShape = transform.createTransformedShape(spriteShape);
        System.out.println("A: " + getBounds());

        g.setColor(Color.BLACK);
        g.fill(spriteShape);
    }

    public void translate(double x, double y) {
        x = getX() + x;
        y = getY() + y;
        transform.translate(x,y);
    }
}
