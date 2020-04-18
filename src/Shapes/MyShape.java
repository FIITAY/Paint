package Shapes;

import java.awt.*;

/**
 * class that represent the basic attributes of shape
 * @author Itay Finci
 */
public abstract class MyShape {
    protected Point origin;
    protected Point target;
    protected Color color;

    /**
     * basic constructor that keeps encapsulation
     * @param origin the point the shape is started
     * @param target the point the shape end
     * @param color the color of the shape
     */
    public MyShape(Point origin, Point target, Color color){
        this.origin = new Point(origin);
        this.target = new Point(target);
        this.color = color;
    }

    /**
     * shapes will implement this method to be drawn
     * @param g the graphics manager
     */
    public abstract void draw(Graphics g);

    /**
     * getter for the origin to be able to make new shapes that start from the same point
     * @return copy of origin
     */
    public Point getOrigin() {
        return new Point(origin);
    }

    /**
     * getter for the color of the shape
     * @return the color of the shape
     */
    public Color getColor() {
        return color;
    }

}
