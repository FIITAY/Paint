package Shapes;

import javax.swing.*;
import java.awt.*;

/**
 * makes new shapes with this factory, helps share settings throw different screens
 * @author Itay Finci
 */
public class ShapeFactory {
    /**
     * the shapes that the factory supports, and representing strings for them
     */
    public enum Shapes {OVAL("Oval"), CIRCLE("Circle"),RECTANGLE("Rectangle"),
        ROUNDED_RECTANGLE("Rounded Rectangle"), LINE("Line"), FREE_DRAW("Free Draw");
        private String representingString;
        private JRadioButton representingButton;

        Shapes(String name){
            representingString = name;
        }

        @Override
        public String toString() {
            return representingString;
        }

        public void setRepresentingButton(JRadioButton button){
            representingButton = button;
        }

        public void setSelected(){
            representingButton.setSelected(true);
        }
    }

    private static Shapes selectedShape = Shapes.RECTANGLE;
    private static boolean makeFilled = true;
    private static int roundness = 20;
    private static Color color = Color.BLACK;
    private static int thickness = 1;
    private static JCheckBox filledBox;
    private static JSlider slider;

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
                return new MyRectangle(origin, target, color, makeFilled, thickness);
            case ROUNDED_RECTANGLE: //make new rounded rectangle
                return new MyRoundedRectangle(origin, target, color, makeFilled, roundness, thickness);
            case OVAL: //make new oval
                return new MyOval(origin, target, color, makeFilled, thickness);
            case CIRCLE: //make new circle
                return new MyCircle(origin,target,color,makeFilled,thickness);
            case FREE_DRAW: //start new free draw
                return new FreeDrawShape(origin,target,color,thickness);
            case LINE: //make new line
                return new MyLine(origin, target, color, thickness);
        }
        //if the shape that is picked not valid
        return null;
    }

    public static MyShape changeShape(MyShape shape, Point target){
        if(shape instanceof FreeDrawShape)
            ((FreeDrawShape)shape).add(target);
        else
            shape.target = new Point(target);
        return shape;
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

    public static void setCheckFilled(boolean filled) {
        filledBox.setSelected(filled);
    }

    public static void setFilledBox(JCheckBox box){
        filledBox = box;
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

    /**
     * @return the current defined line thickness - this will be used for the next created shape unless changed
     */
    public static int getThickness() {
        return thickness;
    }

    /**
     * set the thickness for the next created object
     * @param thickness the new thickness
     */
    public static void setThickness(int thickness) {
        ShapeFactory.thickness = thickness;
    }

    /**
     * set the thickness value using the slider- in order to keep the UI updated
     * @param step the step value to take
     */
    public static void increaseLine(int step) {
        slider.setValue(slider.getValue() + step);
    }

    /**
     * set the UI slider in use
     * @param s the slider
     */
    public static void setSlider(JSlider s){
        slider = s;
    }
}
