package KeyBoard;

import Shapes.ShapeFactory;

import Shapes.ShapeFactory.Shapes;

public class ShapeAdapter {

    public static final int SLIDER_STEP = 5;

    public Object changeRectangle(Object p){
        Shapes.RECTANGLE.setSelected();
        return null;
    }

    public Object changeRoundedRectangle(Object p){
        Shapes.ROUNDED_RECTANGLE.setSelected();
        return null;
    }

    public Object changeCircle(Object p){
        Shapes.CIRCLE.setSelected();
        return null;
    }

    public Object changeOval(Object o) {
        Shapes.OVAL.setSelected();
        return null;
    }

    public Object changeLine(Object p){
        Shapes.LINE.setSelected();
        return null;
    }

    public Object changeFreeDraw(Object o) {
        Shapes.FREE_DRAW.setSelected();
        return null;
    }

    public Object changeFill(Object o) {
        ShapeFactory.setCheckFilled(!ShapeFactory.isFilled());
        return null;
    }

    public Object increaseLineThickness(Object o){
        ShapeFactory.increaseLine(SLIDER_STEP);
        return null;
    }

    public Object decreaseLineThickness(Object o){
        ShapeFactory.increaseLine(-SLIDER_STEP);
        return null;
    }
}
