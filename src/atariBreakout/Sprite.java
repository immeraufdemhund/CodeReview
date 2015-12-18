package atariBreakout;

import java.awt.*;

public abstract class Sprite {
    protected double x;
    protected double y;
    protected Shape spriteShape;
    public double getX() {
        return spriteShape.getBounds().getX();
    }

    public double getY() { return spriteShape.getBounds().getY(); }

    public Rectangle getBounds() {return  spriteShape.getBounds();}

    public abstract void drawSprite(Graphics2D g);
}
