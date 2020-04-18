package Shapes;

import java.awt.*;

public class MyLine extends MyShape {

    /**
     * makes a new line
     * @param origin the origin point of the line
     * @param target the end point of the line
     * @param color the color of the line
     */
    public MyLine(Point origin, Point target, Color color){
        super(origin, target, color);
    }

    @Override
    public void draw(Graphics g) {
        //sets the color of the line
        g.setColor(color);
        //draws the line
        g.drawLine(origin.x,origin.y,target.x,target.y);
    }
}
