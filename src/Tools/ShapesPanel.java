package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static Shapes.ShapeFactory.Shapes;

public class ShapesPanel extends JPanel implements ItemListener {

    private ShapeFactory factory;

    public ShapesPanel(ShapeFactory factory){
        this.factory = factory;
        ButtonGroup options = new ButtonGroup();
        setLayout(new GridLayout(0, 1));
        JRadioButton radioButton;
        //make the radio button stack vertical
        for(Shapes shape : Shapes.values()){
            radioButton = new JRadioButton(shape.toString(),true);
            radioButton.addItemListener(this);
            options.add(radioButton);
            add(radioButton);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED && e.getItem() != null) {
            String buttonText = ((JRadioButton) e.getItem()).getText();
            //determine which of the shapes should be enabled, and update the factory as needed
            if(buttonText.equals(Shapes.RECTANGLE))
                factory.setSelectedShape(ShapeFactory.Shapes.RECTANGLE);
            else if(buttonText.equals(Shapes.ROUNDED_RECTANGLE))
                factory.setSelectedShape(ShapeFactory.Shapes.ROUNDED_RECTANGLE);
            else if(buttonText.equals(Shapes.OVAL))
                factory.setSelectedShape(ShapeFactory.Shapes.OVAL);
            else if(buttonText.equals(Shapes.LINE))
                factory.setSelectedShape(ShapeFactory.Shapes.LINE);
        }
    }
}
