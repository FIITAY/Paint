package Shapes;

import java.awt.*;

public class MyRectangle extends MyCompoundShape {

    public MyRectangle(Point origin, Point target, Color color, boolean isFilled) {
        super(origin,target,color, isFilled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        if(isFilled()) {
            g.fillRect(start.x, start.y, width, height);
        } else {
            g.drawRect(start.x, start.y, width, height);
        }
    }
}
