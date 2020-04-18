package Shapes;

import java.awt.*;

public class MyLine extends MyShape {

    public MyLine(Point origin, Point target, Color color){
        super(origin, target, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(origin.x,origin.y,target.x,target.y);
    }
}
