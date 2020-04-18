package Shapes;

import java.awt.*;

/**
 * a rectangle shape class that knows how to draw the rectangle
 * @author Itay Finci
 */
public class MyRectangle extends MyCompoundShape {

    /**
     * makes new rectangle
     * @param origin the origin of the rectangle
     * @param target the end of the rectangle
     * @param color the color of the rectangle
     * @param isFilled if the rectangle is filled or outlined
     */
    public MyRectangle(Point origin, Point target, Color color, boolean isFilled) {
        super(origin,target,color, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        //sets the rectangle color
        g.setColor(color);
        //calculate the rectangle width, height and start point
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        //check if the rectangle is filled of empty
        if(isFilled()) {
            g.fillRect(start.x, start.y, width, height);
        } else {
            g.drawRect(start.x, start.y, width, height);
        }
    }
}
