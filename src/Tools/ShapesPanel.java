package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShapesPanel extends JPanel implements ItemListener {

    private static final String REC_STR = "Rectangle";
    private static final String ROUND_REC_STR = "Rounded Rectangle";
    private static final String OVAL_STR = "Oval";
    private static final String LINE_STR = "Line";

    private ShapeFactory factory;

    public ShapesPanel(ShapeFactory factory){
        this.factory = factory;
        ButtonGroup options = new ButtonGroup();
        setLayout(new GridLayout(0, 1));
        JRadioButton radioButton;
        //make the radio button stack vertical
        for(ShapeFactory.Shapes shape : ShapeFactory.Shapes.values()){
            radioButton = new JRadioButton(shape.toString(),true);
            radioButton.addItemListener(this);
            options.add(radioButton);
            add(radioButton);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED && e.getItem() != null) {
            String test = ((JRadioButton) e.getItem()).getText();
            switch (test){
                case REC_STR:
                    factory.setSelectedShape(ShapeFactory.Shapes.RECTANGLE);
                    break;
                case ROUND_REC_STR:
                    factory.setSelectedShape(ShapeFactory.Shapes.ROUNDED_RECTANGLE);
                    break;
                case OVAL_STR:
                    factory.setSelectedShape(ShapeFactory.Shapes.OVAL);
                    break;
                case LINE_STR:
                    factory.setSelectedShape(ShapeFactory.Shapes.LINE);
                    break;
            }
        }
    }
}
