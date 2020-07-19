package Painting;

import Shapes.MyShape;
import Shapes.ShapeFactory;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * controlls the mouse input and update the screen accordingly
 */
public class MouseController implements MouseListener, MouseMotionListener {

    public enum MouseMode {DRAG, CLICK}

    private MyShape hand;

    private StackController stackController;
    private DrawingPanel panel;

    private static MouseMode currentMode = MouseMode.CLICK;

    public MouseController(StackController sc, DrawingPanel panel) {
        this.hand = null;
        this.stackController = sc;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(currentMode == MouseMode.CLICK)
            startAndStopDrawing(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(currentMode == MouseMode.DRAG)
            startAndStopDrawing(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(currentMode == MouseMode.DRAG)
            startAndStopDrawing(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentMode == MouseMode.DRAG)
            drawingUpdate(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(currentMode == MouseMode.CLICK)
            drawingUpdate(e);
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
        panel.repaint();
    }

    /**
     * if the program is in the middle of drawing and there is mouse event then
     * update the shape in the hand to the new data
     * @param e the mouse event with the mouse point
     */
    private void drawingUpdate(MouseEvent e) {
        //if there is shape in hand when the mouse moved update it
        if (hand != null) {
            //make a new shape with the same origin as the old, and the mouse point as target
            hand = ShapeFactory.changeShape(hand, e.getPoint());
            //repaint the screen to show the update
            panel.repaint();
        }
    }

    /**
     * paint the content of the hand
     * @param g the manager
     */
    public void paintHand(Graphics g){
        if(hand != null)
            hand.draw(g);
    }

    /**
     * toggle the mode of the mouse between drag and click
     */
    public static MouseMode toggleMode(){
        if(currentMode == MouseMode.DRAG)
            currentMode = MouseMode.CLICK;
        else
            currentMode = MouseMode.DRAG;
        return currentMode;
    }

    public static MouseMode getCurrentMode(){
        return currentMode;
    }
}
