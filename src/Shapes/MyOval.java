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
     */
    public MyOval(Point origin, Point target, Color color, boolean filled) {
        super(origin, target, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        //sets the oval color
        g.setColor(color);
        //calc the width, height and start point of the oval
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        //check if the oval is filled or not
        if(isFilled()){
            g.fillOval(start.x, start.y, width, height);
        } else {
            g.drawOval(start.x, start.y, width, height);
        }
    }
}
