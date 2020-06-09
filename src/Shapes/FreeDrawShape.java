package Shapes;

import java.awt.*;
import java.util.LinkedList;

public class FreeDrawShape extends MyShape{

    private Point p1 ;
    private Point p2 ;
    private LinkedList<MyLine> vec;

    /**
     * a constructor to make new freeDrawShape
     *
     * @param origin    the point the shape is started
     * @param target    the point the shape end
     * @param color     the color of the shape
     * @param thickness the line thickness
     */
    public FreeDrawShape(Point origin, Point target, Color color, int thickness) {
        super(origin, target, color, thickness);
        //make the program stroke that will be able to look fluid
        stroke = new BasicStroke(thickness,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        //this array will store all of the small lines
        vec = new LinkedList<>();
        //add the initial points to the array
        add(origin);
        add(target);
    }

    @Override
    public void draw(Graphics g) {
        //draw all of the shapes of this free draw shape
        for(MyShape s: vec){
            s.draw(g);
        }
    }

    /**
     * add new segment to this shape
     * @param target the point to connect
     */
    public void add(Point target) {
        //make copy of the point
        Point copiedTarget = new Point(target.x, target.y);
        //update the point args of the shape
        if(p2 == null)
            p1 = copiedTarget;
        else
            p1 = p2;
        p2 = copiedTarget;
        //make new line with the new point
        MyLine line = new MyLine(p1, p2, color, thickness);
        //set the stroke of the line
        line.stroke = this.stroke;
        //add the line to the shape
        vec.add(line);
    }
}
