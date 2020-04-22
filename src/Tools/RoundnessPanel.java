package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * a panel that controls how round the roundedRectangle is
 * @author Itay Finci
 */
public class RoundnessPanel extends JPanel {

    private JLabel label;
    private JLabel percents;
    private JTextField textField;

    public RoundnessPanel() {
        super();
        //make sure the layout is stuck to the left
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //makes the labels that the user use to understand
        label = new JLabel("Rectangle Roundness:");
        percents = new JLabel("%");
        makeFormattedTextField();
        //add the componments to the panel
        add(label);
        add(textField);
        add(percents);
    }

    /**
     * makes new text field that only allows you to enter numbers character (0,1,2,3,4,5,6,7,8,9)
     * and makes sure that the number inside is between 0 to 100.
     */
    private void makeFormattedTextField(){
        textField = new JTextField(""+ShapeFactory.getRoundness(), 3);
        //add listener that happens after each type and make the field accept only numbers between 0 to 100
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                typeEvent(e);
            }
        });
    }

    /**
     * when pressing a key
     * 1. validate that the new value is legal
     * 2. update the value that is in the ShapeFactory
     * @param e the key type event
     */
    public void typeEvent(KeyEvent e) {
        char typed = e.getKeyChar();
        //if the char is not a number remove the char
        if (typed < '0' || typed > '9') {
            //input is illigal so put empty char insted of the sent char
            e.setKeyChar(Character.MIN_VALUE);
        } else {
            //update the text that is in the text filed and the value in the factory
            updateShapeFactory(updateValue(e));
        }
        //show the update
        repaint();
    }

    /**
     * @return the value that is in the textField
     */
    private int getCurrentValue() {
        int currentValue;
        try {
            //parse the textField text to int
            currentValue = Integer.parseInt(textField.getText());
        }catch (NumberFormatException exception) {
            //the field is empty so the current value is 0
            currentValue = 0;
        }
        return currentValue;
    }

    /**
     * update the value that is in the text field after the type
     * @param e the key press event
     * @return the new value of the text field
     */
    private int updateValue(KeyEvent e) {
        //get the current value and move to the left 1 spot
        int afterUpdateVal = getCurrentValue()*10;
        //add the new value
        afterUpdateVal += e.getKeyChar() - '0';
        //if the value is more then 100, then cap it to 100
        if(afterUpdateVal > 100) {
            afterUpdateVal = 100;
            //dont print the sent char, print empty char
            e.setKeyChar(Character.MIN_VALUE);
            //sets the new value in the text
            textField.setText("" + afterUpdateVal);
        }
        return afterUpdateVal;
    }

    /**
     * update the value that is in the factory
     * @param value the new value
     */
    private void updateShapeFactory(int value) {
        ShapeFactory.setRoundness(value);
    }
}
