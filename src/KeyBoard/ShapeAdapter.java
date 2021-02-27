package KeyBoard;

import Shapes.ShapeFactory;
import Shapes.ShapeFactory.Shapes;

/**
 * access the global constants in the Shapes enums in order to activate user changes
 * @author Itay Finci
 */
public class ShapeAdapter {

    public static final int SLIDER_STEP = 5;

    /**
     * set the new selected shape to rectangle
     * @param p for compatibility with :: expressions
     * @return null
     */
    public Object changeRectangle(Object p){
        Shapes.RECTANGLE.setSelected();
        return null;
    }

    /**
     * set the new selected shape to rounded rectangle
     * @param p for compatibility with :: expressions
     * @return null
     */
    public Object changeRoundedRectangle(Object p){
        Shapes.ROUNDED_RECTANGLE.setSelected();
        return null;
    }

    /**
     * set the new selected shape to circle
     * @param p for compatibility with :: expressions
     * @return null
     */
    public Object changeCircle(Object p){
        Shapes.CIRCLE.setSelected();
        return null;
    }

    /**
     * set the new selected shape to oval
     * @param o for compatibility with :: expressions
     * @return null
     */
    public Object changeOval(Object o) {
        Shapes.OVAL.setSelected();
        return null;
    }

    /**
     * set the new selected shape to line
     * @param p for compatibility with :: expressions
     * @return null
     */
    public Object changeLine(Object p){
        Shapes.LINE.setSelected();
        return null;
    }

    /**
     * set the new selected shape to pen tool
     * @param o for compatibility with :: expressions
     * @return null
     */
    public Object changeFreeDraw(Object o) {
        Shapes.FREE_DRAW.setSelected();
        return null;
    }

    /**
     * set the new fill method selected
     * @param o for compatibility with :: expressions
     * @return null
     */
    public Object changeFill(Object o) {
        ShapeFactory.setCheckFilled(!ShapeFactory.isFilled());
        return null;
    }

    /**
     * increase the line thickness
     * @param o for compatibility with :: expressions
     * @return null
     */
    public Object increaseLineThickness(Object o){
        ShapeFactory.increaseLine(SLIDER_STEP);
        return null;
    }

    /**
     * decrease the line thickness
     * @param o for compatibility with :: expressions
     * @return null
     */
    public Object decreaseLineThickness(Object o){
        ShapeFactory.increaseLine(-SLIDER_STEP);
        return null;
    }
}
