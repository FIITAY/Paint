package Shapes;

import java.awt.*;

public class MyCircle extends MyOval{

    /**
     * makes a new circle
     *
     * @param origin    the origin point of the oval
     * @param target    the end point of the oval
     * @param color     the color of the oval
     * @param filled    if the oval is filled or outlined
     * @param thickness the line thickness
     */
    public MyCircle(Point origin, Point target, Color color, boolean filled, int thickness) {
        super(origin, target, color, filled, thickness);
    }

    @Override
    protected int calculateHeight() {
        var height =  super.calculateHeight();
        var width = super.calculateWidth();
        return Math.min(height, width);
    }

    @Override
    protected int calculateWidth() {
        return calculateHeight();
    }
}
