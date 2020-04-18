package Shapes;

import java.awt.*;

public class ShapeFactory {
    public enum Shapes {OVAL, RECTANGLE, ROUNDED_RECTANGLE, LINE}

    private Shapes selectedShape;
    private boolean makeFilled;
    private int roundness;

    public ShapeFactory() {
        //put default values inside the attributes
        selectedShape = Shapes.RECTANGLE;
        makeFilled = true;
        roundness = 0;
    }

    public MyShape getShape(Point origin, Point target, Color color){
        switch (selectedShape){
            case RECTANGLE:
                return new MyRectangle(origin, target, color, makeFilled);
            case ROUNDED_RECTANGLE:
                return new MyRoundedRectangle(origin, target, color, makeFilled, roundness);
            case OVAL:
                return new MyOval(origin, target, color, makeFilled);
            case LINE:
                return new MyLine(origin, target, color);
        }
        //if the shape that is picked not valid
        return null;
    }
}
