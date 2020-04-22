package Painting;

import Shapes.MyShape;

public class StackController {
    private ShapeStack controlled;
    private DrawingPanel effectedPanel;

    public StackController(ShapeStack stack, DrawingPanel effectedPanel){
        controlled = stack;
        this.effectedPanel = effectedPanel;
    }

    public void undo(){
        controlled.pop();
        finishChange();
    }

    public void clear(){
        controlled.clear();
        finishChange();
    }

    public void insert(MyShape shape) {
        controlled.insert(shape);
        finishChange();
    }

    //call this method to finish each of the methods, called in the end of all of the public methods.
    private void finishChange(){
        effectedPanel.repaint();
    }

}
