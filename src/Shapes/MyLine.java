package Shapes;

import java.awt.*;

/**
 * represents line that can be drawn
 * @author Itay Finci
 */
public class MyLine extends MyShape {

    /**
     * makes a new line
     * @param origin the origin point of the line
     * @param target the end point of the line
     * @param color the color of the line
     * @param thickness the line thickness
     */
    public MyLine(Point origin, Point target, Color color, int thickness) {
        super(origin, target, color, thickness);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setStroke(stroke);
        //sets the color of the line
        graphics2D.setColor(color);
        graphics2D.drawLine(origin.x,origin.y,target.x,target.y);
    }
}
