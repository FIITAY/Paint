package Painting;

import Shapes.MyShape;

/**
 * send commands to the shape stack and update the drawing panel after the command have been done.
 * @author Itay Finci
 */
public class StackController {
    private ShapeStack controlled;
    private DrawingPanel effectedPanel;

    public StackController(ShapeStack stack, DrawingPanel effectedPanel){
        //save the controlled object without encapsulation to make sure the used object are being controlled
        controlled = stack;
        this.effectedPanel = effectedPanel;
    }

    /**
     * undo the last user drawing
     */
    public void undo(){
        //remove the last added shape
        controlled.pop();
        finishChange();
    }

    /**
     * clear the screen
     */
    public void clear(){
        //remove all of the shapes from the stack
        controlled.clear();
        finishChange();
    }

    /**
     * insert new shape into the stack
     * @param shape the new shape that needs to be inserted
     */
    public void insert(MyShape shape) {
        controlled.insert(shape);
        finishChange();
    }

    //call this method to finish each of the methods, called in the end of all of the public methods.
    private void finishChange(){
        //repaint to show changes
        effectedPanel.repaint();
    }

}
