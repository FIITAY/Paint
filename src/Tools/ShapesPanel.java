package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static Shapes.ShapeFactory.Shapes;

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
        for(Shapes shape : Shapes.values()){
            radioButton = new JRadioButton(shape.toString());
            radioButton.addItemListener(this);
            options.add(radioButton);
            add(radioButton);
            //if this button is the one who is the default in the factory, set it selected
            if(ShapeFactory.getSelectedShape().equals(shape)){
                radioButton.setSelected(true);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED && e.getItem() != null) {
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
        }
    }
}
