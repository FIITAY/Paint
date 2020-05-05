package Shapes;

import java.awt.*;

/**
 * a rectangle shape class that knows how to draw the rectangle
 * @author Itay Finci
 */
public class MyRectangle extends MyBoundedShape {

    /**
     * makes new rectangle
     * @param origin the origin of the rectangle
     * @param target the end of the rectangle
     * @param color the color of the rectangle
     * @param isFilled if the rectangle is filled or outlined
     * @param thickness the line thickness
     */
    public MyRectangle(Point origin, Point target, Color color, boolean isFilled, int thickness) {
        super(origin,target,color, isFilled, thickness);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d= (Graphics2D)g;
        //set the color of the graphics to be as the shape color
        g2d.setColor(color);
        g2d.setStroke(stroke);
        //calculate the rectangle width, height and start point
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        //check if the rectangle is filled of empty
        if(isFilled()) {
            g2d.fillRect(start.x, start.y, width, height);
        } else {
            g2d.drawRect(start.x, start.y, width, height);
        }
    }
}
