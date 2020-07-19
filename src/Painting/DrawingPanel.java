package Painting;

import Shapes.MyShape;

import javax.swing.*;
import java.awt.*;

/**
 * a panel that allows you to draw on it with your mouse
 * @author Itay Finci
 */
public class DrawingPanel extends JPanel {
    private ShapeStack stack;
    private StackController stackController;
    private MouseController mouseController;

    public DrawingPanel() {
        super();
        //make the stack for saving shapes
        stack = new ShapeStack();
        //make new StackController to control the drawing panel stack
        stackController = new StackController(stack, this);
        addListeners();
    }

    /**
     * make listeners for mouse click and moving events
     */
    private void addListeners() {
        //make listener that will handle start and stop drawing of shapes
        mouseController = new MouseController(stackController, this);
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    /**
     * @return object that can sends commands to the shape stack
     */
    public StackController getStackController() {
        return stackController;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw all of the shapes
        stack.drawStack(g);
        //if there is shape in hand draw it
        mouseController.paintHand(g);
    }
}
