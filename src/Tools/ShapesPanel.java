package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static Shapes.ShapeFactory.Shapes;

/**
 * a panel that allows the user to choose what shape is beeing drawn
 * @author Itay Finci
 */
public class ShapesPanel extends JPanel implements ItemListener {

    private ButtonGroup options;

    public ShapesPanel(){
        options = new ButtonGroup();
        //make the radio button stack vertical
        setLayout(new GridLayout(0, 1));
        makeRadioButtons();
    }

    /**
     * make radio button for each shape
     */
    private void makeRadioButtons(){
        JRadioButton radioButton;
        //add radio button for each of the shapes that the ShapeFactory supports
        for(Shapes shape : Shapes.values()){
            //make new radio button with the correct string
            radioButton = new JRadioButton(shape.toString());
            //add listiner for change in the button state
            radioButton.addItemListener(this);
            //add the button to the button group
            options.add(radioButton);
            shape.setRepresentingButton(radioButton);
            //add the button to the panel
            add(radioButton);
            //if this button is the one who is the default in the factory, set it selected
            if(ShapeFactory.getSelectedShape().equals(shape)){
                radioButton.setSelected(true);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //check if the item is changed to be selected and is not null (in the initialization can get null item)
        if(e.getStateChange() == ItemEvent.SELECTED && e.getItem() != null) {
            //get the string that is written to the user
            String buttonText = ((JRadioButton) e.getItem()).getText();
            //determine which of the shapes should be enabled, and update the factory as needed
            if(buttonText.equals(Shapes.RECTANGLE.toString()))
                ShapeFactory.setSelectedShape(ShapeFactory.Shapes.RECTANGLE);
            else if(buttonText.equals(Shapes.ROUNDED_RECTANGLE.toString()))
                ShapeFactory.setSelectedShape(ShapeFactory.Shapes.ROUNDED_RECTANGLE);
            else if(buttonText.equals(Shapes.OVAL.toString()))
                ShapeFactory.setSelectedShape(ShapeFactory.Shapes.OVAL);
            else if(buttonText.equals(Shapes.LINE.toString()))
                ShapeFactory.setSelectedShape(ShapeFactory.Shapes.LINE);
            else if(buttonText.equals(Shapes.CIRCLE.toString()))
                ShapeFactory.setSelectedShape(ShapeFactory.Shapes.CIRCLE);
        }
    }
}
