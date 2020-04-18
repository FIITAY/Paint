package Shapes;

import java.awt.*;

public abstract class MyShape {
    protected Point origin;
    protected Point target;
    protected Color color;

    public MyShape(Point origin, Point target, Color color){
        this.origin = new Point(origin);
        this.target = new Point(target);
        this.color = color;
    }

    public abstract void draw(Graphics g);



}
