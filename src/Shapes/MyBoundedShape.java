package Shapes;

import java.awt.*;

/**
 * represent shapes that have area
 * @author Itay Finci
 */
public abstract class MyBoundedShape extends MyShape {

    private boolean filled;

    /**
     * makes new compound shape
     * @param origin the origin of the shape
     * @param target the end point of the shape
     * @param color the color of the shape
     * @param filled if the shape is filled or outlined
     */
    public MyBoundedShape(Point origin, Point target, Color color, boolean filled, int thickness) {
        super(origin,target,color,thickness);
        this.filled = filled;
    }

    protected boolean isFilled() {
        return filled;
    }

    /**
     * finds the point to start drawing from
     * to allow drawing shapes that the target is smaller then the origin
     * @return a point to start drawing the shape from
     */
    protected Point findStart() {
        int x = Math.min(origin.x, target.x);
        int y = Math.min(origin.y, target.y);
        return new Point(x,y);
    }

    /**
     * @return the abs value of the width of the shape
     */
    protected int calculateWidth() {
        return Math.abs(target.x - origin.x);
    }

    /**
     * @return the abs value of the height of the shape
     */
    protected int calculateHeight() {
        return Math.abs(target.y - origin.y);
    }
}
