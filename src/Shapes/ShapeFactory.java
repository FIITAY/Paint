package Shapes;

import java.awt.*;

/**
 * makes new shapes with this factory, helps share settings throw different screens
 * @author Itay Finci
 */
public class ShapeFactory {
    /**
     * the shapes that the factory supports, and representing strings for them
     */
    public enum Shapes {OVAL("Oval"), RECTANGLE("Rectangle"),
        ROUNDED_RECTANGLE("Rounded Rectangle"), LINE("Line");
        private String representingString;

        Shapes(String name){
            representingString = name;
        }

        @Override
        public String toString() {
            return representingString;
        }
    }

    private static Shapes selectedShape = Shapes.RECTANGLE;
    private static boolean makeFilled = true;
    private static int roundness = 20;
    private static Color color = Color.BLACK;

    /**
     * makes a new shape base of the settings of the factory and the parameters
     * @param origin the origin point of the shape
     * @param target the end point of the shape
     * @return the new shape object
     */
    public static MyShape getShape(Point origin, Point target){
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

    /**
     * get the selected color
     * @return the current color that will be given to new shapes
     */
    public static Color getColor() {
        return color;
    }

    /**
     * sets the color that will be for new shapes
     * @param c the color to set
     */
    public static void setColor(Color c) {
        color = c;
    }

    /**
     * set the shape that will be drawn
     * @param shape the shape to draw next
     */
    public static void setSelectedShape(Shapes shape){
        selectedShape = shape;
    }

    /**
     * get the shape that will be made if getShape is called
     * @return a Shape enum var
     */
    public static Shapes getSelectedShape(){
        return selectedShape;
    }

    /**
     * get if the shape will be filled or not
     * @return true if the next shape will be filled
     */
    public static boolean isFilled() {
        return makeFilled;
    }

    /**
     * set if the next shape should be filled
     * @param filled true if you want the next shape to be filled
     */
    public static void setFilled(boolean filled) {
        makeFilled = filled;
    }

    /**
     * get the round % of new Rounded rectangle
     * @return the % of each line that turns to arc
     */
    public static int getRoundness() {
        return roundness;
    }

    /**
     * set how much of each line will turn to arch
     * @param roundness a integer between 0 to 100 that represent the % of the length that turns to arc
     */
    public static void setRoundness(int roundness) {
        //only if the percentage is legal
        if(roundness >= 0 && roundness <= 100)
            ShapeFactory.roundness = roundness;
    }
}
