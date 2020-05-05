package Painting;

import KeyBoard.KeyBoardManager;
import Shapes.MyShape;
import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * a panel that allows you to draw on it with your mouse
 * @author Itay Finci
 */
public class DrawingPanel extends JPanel {
    private ShapeStack stack;
    private MyShape hand;
    private StackController stackController;

    public DrawingPanel() {
        super();
        //make the stack for saving shapes
        stack = new ShapeStack();
        //make new StackController to control the drawing panel stack
        stackController = new StackController(stack, this);
        //the hand is clear, init the event listeners
        hand = null;
        addListeners();
    }

    /**
     * make listeners for mouse click and moving events
     */
    private void addListeners() {
        //make listener that will handle start and stop drawing of shapes
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startAndStopDrawing(e);
            }
        });
        //add listener for mouse move that will happen each time the mouse moved
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                drawingUpdate(e);
            }
        });

        //addKeyListener(new KeyBoardManager(getStackController()));
    }

    /**
     * if the mouse is pressed check if there is need to start or stop drawing the data.
     * @param e the mouse event with the mouse point
     */
    private void startAndStopDrawing(MouseEvent e){
        //if the hand is empty make new shape, else end the shape drawing and store it in the stack
        if(hand == null) {
            //make new shape from the mouse point to the mouse point
            hand = ShapeFactory.getShape(e.getPoint(), e.getPoint());
        } else{
            //put the shape in the stack and reset the hand
            stackController.insert(hand);
            hand = null;
        }
    }

    /**
     * if the program is in the middle of drawing and there is mouse event then
     * update the shape in the hand to the new data
     * @param e the mouse event with the mouse point
     */
    private void drawingUpdate(MouseEvent e){
        //if there is shape in hand when the mouse moved update it
        if(hand != null) {
            //make a new shape with the same origin as the old, and the mouse point as target
            hand = ShapeFactory.changeShape(hand, e.getPoint());
            //repaint the screen to show the update
            repaint();
        }
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
        if(hand != null)
            hand.draw(g);
    }
}
