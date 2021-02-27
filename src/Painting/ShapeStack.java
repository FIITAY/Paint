package Painting;

import Shapes.MyShape;

import java.awt.*;
import java.util.ArrayList;

/**
 * implement a stack of shapes using ArrayList
 * @author Itay Finci
 */
public class ShapeStack {
    private ArrayList<MyShape> stack;

    /**
     * make empty stack
     */
    public ShapeStack() {
        stack = new ArrayList<MyShape>();
    }

    /**
     * inset shape to the end of the list
     * @param shape the shape to be inserted
     */
    public void insert(MyShape shape) {
        stack.add(shape);
    }

    /**
     * remove the last shape (the most recently added)
     * @return the shape that was removed
     */
    public MyShape pop() {
        //only pop if there are items in the stack
        if(stack.size() >= 1){
            MyShape out = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return out;
        }
        return null;
    }

    /**
     * remove all of the shapes from the stack
     */
    public void clear() {
        stack.clear();
    }

    /**
     * draw the shapes from the stack
     * @param g the graphics manager
     */
    public void drawStack(Graphics g) {
        for(MyShape shape: stack) {
            shape.draw(g);
        }
    }
}
