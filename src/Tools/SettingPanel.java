package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * allows the user to change settings regarding the shape drawing
 * @author Itay Finci
 */
public class SettingPanel extends JPanel implements ItemListener{

    private JCheckBox filled;
    private RoundnessPanel roundnessSettings;
    private ThicknessControllerPanel thickness;

    public SettingPanel(){
        //set the panel layout to be stack on top of each other
        setLayout(new GridLayout(0, 1));
        //make check box that determine if the shape will be drawn filled or not
        filled = new JCheckBox("Fill Shapes", ShapeFactory.isFilled());
        ShapeFactory.setFilledBox(filled);
        filled.addItemListener(this);
        add(filled);
        roundnessSettings = new RoundnessPanel();
        add(roundnessSettings);
        thickness = new ThicknessControllerPanel();
        add(thickness);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //update the factory to have the right fill boolean
        if(e.getStateChange() == ItemEvent.SELECTED) {
            ShapeFactory.setFilled(true);
        } else {
            ShapeFactory.setFilled(false);
        }
    }
}
