package KeyBoard;

import Shapes.ShapeFactory;

import javax.swing.*;
import Shapes.ShapeFactory.Shapes;

public class ShapeAdapter {

    public Object changeRectangle(Object p){
        Shapes shape = Shapes.RECTANGLE;
        ShapeFactory.setSelectedShape(shape);
        shape.setSelected();
        return null;
    }

    public Object changeRoundedRectangle(Object p){
        Shapes shape = Shapes.ROUNDED_RECTANGLE;
        ShapeFactory.setSelectedShape(shape);
        shape.setSelected();
        return null;
    }

    public Object changeCircle(Object p){
        Shapes shape = Shapes.OVAL;
        ShapeFactory.setSelectedShape(shape);
        shape.setSelected();
        return null;
    }

    public Object changeLine(Object p){
        Shapes shape = Shapes.LINE;
        ShapeFactory.setSelectedShape(shape);
        shape.setSelected();
        return null;
    }
}
