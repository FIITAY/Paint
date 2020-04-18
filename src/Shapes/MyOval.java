package Shapes;

import java.awt.*;

public class MyOval extends MyCompoundShape{
    public MyOval(Point origin, Point target, Color color, boolean filled) {
        super(origin, target, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int width = calculateWidth();
        int height = calculateHeight();

        Point start = findStart();

        if(isFilled()){
            g.fillOval(start.x, start.y, width, height);
        } else {
            g.drawOval(start.x, start.y, width, height);
        }
    }
}
