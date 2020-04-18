package Shapes;

import java.awt.*;

/**
 * makes new shapes with this factory, helps share settings throw different screens
 * @author Itay Finci
 */
public class ShapeFactory {
    /**
     * the shapes that the factory supports
     */
    public enum Shapes {OVAL, RECTANGLE, ROUNDED_RECTANGLE, LINE}

    private Shapes selectedShape;
    private boolean makeFilled;
    private int roundness;

    /**
     * makes shape factory with default settings
     */
    public ShapeFactory() {
        //put default values inside the attributes
        selectedShape = Shapes.RECTANGLE;
        makeFilled = true;
        roundness = 0;
    }

    /**
     * makes a new shape base of the settings of the factory and the parameters
     * @param origin the origin point of the shape
     * @param target the end point of the shape
     * @param color the color of the shape
     * @return the new shape object
     */
    public MyShape getShape(Point origin, Point target, Color color){
        // check which shape is currently selected
        switch (selectedShape){
            case RECTANGLE: //make new rectangle
                return new MyRectangle(origin, target, color, makeFilled);
            case ROUNDED_RECTANGLE: //make new rounded rectangle
                return new MyRoundedRectangle(origin, target, color, makeFilled, roundness);
            case OVAL: //make new oval
                return new MyOval(origin, target, color, makeFilled);
            case LINE: //make new line
                return new MyLine(origin, target, color);
        }
        //if the shape that is picked not valid
        return null;
    }
}
