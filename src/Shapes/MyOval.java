package Shapes;

import java.awt.*;

/**
 * makes a oval and draws it
 * @author Itay Finci
 */
public class MyOval extends MyBoundedShape {
    /**
     * makes a new oval
     * @param origin the origin point of the oval
     * @param target the end point of the oval
     * @param color the color of the oval
     * @param filled if the oval is filled or outlined
     * @param thickness the line thickness
     */
    public MyOval(Point origin, Point target, Color color, boolean filled, int thickness) {
        super(origin, target, color, filled, thickness);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d= (Graphics2D)g;
        //set the color of the graphics to be as the shape color
        g2d.setColor(color);
        g2d.setStroke(stroke);
        //calc the width, height and start point of the oval
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        //check if the oval is filled or not
        if(isFilled()){
            g2d.fillOval(start.x, start.y, width, height);
        } else {
            g2d.drawOval(start.x, start.y, width, height);
        }
    }
}
