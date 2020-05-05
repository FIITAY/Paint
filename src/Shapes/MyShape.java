package Shapes;

import java.awt.*;

/**
 * class that represent the basic attributes of shape
 * @author Itay Finci
 */
public abstract class MyShape{
    protected Point origin;
    protected Point target;
    protected Color color;
    protected int thickness;
    protected Stroke stroke;

    /**
     * basic constructor that keeps encapsulation
     * @param origin the point the shape is started
     * @param target the point the shape end
     * @param color the color of the shape
     * @param thickness the line thickness
     */
    public MyShape(Point origin, Point target, Color color, int thickness) {
        this.origin = new Point(origin);
        this.target = new Point(target);
        this.color = color;
        this.thickness = thickness;
        this.stroke = new BasicStroke(thickness);
    }

    /**
     * shapes will implement this method to be drawn
     * @param g the graphics manager
     */
    public abstract void draw(Graphics g);
}
