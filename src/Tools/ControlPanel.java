package Tools;

import Painting.StackController;

import javax.swing.*;
import java.awt.*;

/**
 * a panel that have buttons that control the program
 * @author Itay Finci
 */
public class ControlPanel extends JPanel {
    private StackController stackController;

    //Texts
    private static final String UNDO_STR = "undo last drawing";
    private static final String CLEAR_STR = "clear screen";
    private static final String EXIT_STR = "exit the program";

    //buttons
    private JButton bUndo;
    private JButton bClear;
    private JButton bExit;

    public ControlPanel(StackController stackController) {
        this.stackController = stackController;
        //make all of the buttons stack on top of each other
        setLayout(new GridLayout(0,1));
        addUndoButton();
        addClearButton();
        addExitButton();
    }

    /**
     * makes the undo button and make the action listener
     */
    private void addUndoButton() {
        bUndo = new JButton(UNDO_STR);
        //the action listener undo last drawing after the button is pressed
        bUndo.addActionListener(e -> stackController.undo());
        //add the button
        add(bUndo);
    }

    /**
     * makes button that allow to clear the screen
     */
    private void addClearButton(){
        bClear = new JButton(CLEAR_STR);
        //the action listener clear the stack after the button is pressed
        bClear.addActionListener(e -> stackController.clear());
        //add the button
        add(bClear);
    }

    /**
     * makes a button that exits the program completely
     */
    private void addExitButton(){
        bExit = new JButton(EXIT_STR);
        //add action listener that after pressing the button exits the program without error.
        bExit.addActionListener(e -> System.exit(0));
        //add the button
        add(bExit);
    }
}
