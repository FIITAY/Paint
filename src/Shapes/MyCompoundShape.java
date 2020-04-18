package Shapes;

import java.awt.*;

public abstract class MyCompoundShape extends MyShape {
    private boolean filled;

    public MyCompoundShape(Point origin, Point target, Color color, boolean filled) {
        super(origin,target,color);
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

    protected int calculateWidth() {
        return Math.abs(target.x - origin.x);
    }

    protected int calculateHeight() {
        return Math.abs(target.y - origin.y);
    }
}
