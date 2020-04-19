package Painting;

import Shapes.MyShape;
import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingPanel extends JPanel {
    private ShapeStack stack;
    private MyShape hand;

    public DrawingPanel() {
        super();
        //make the stack for saving shapes
        stack = new ShapeStack();
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
                //if the hand is empty make new shape, else end the shape drawing and store it in the stack
                if(hand == null) {
                    //make new shape from the mouse point to the mouse point
                    hand = ShapeFactory.getShape(e.getPoint(), e.getPoint());
                } else{
                    //put the shape in the stack and reset the hand
                    stack.insert(hand);
                    hand = null;
                }
                //repaint the screen to show the update
                repaint();
            }
        });
        //add listener for mouse move that will happen each time the mouse moved
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                //if there is shape in hand when the mouse moved update it
                if(hand != null) {
                    //make a new shape with the same origin as the old, and the mouse point as target
                    hand = ShapeFactory.getShape(hand.getOrigin(), e.getPoint());
                    //repaint the screen to show the update
                    repaint();
                }
            }
        });
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
