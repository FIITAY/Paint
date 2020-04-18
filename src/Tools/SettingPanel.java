package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SettingPanel extends JPanel implements ItemListener {

    private ShapeFactory factory;
    private JCheckBox filled;

    public SettingPanel(ShapeFactory factory){
        this.factory = factory;
        //make check box that determine if the shape will be drawn filled or not
        filled = new JCheckBox("Fill Shapes", factory.isFilled());
        filled.addItemListener(this);
        add(filled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            factory.setFilled(true);
        } else {
            factory.setFilled(false);
        }
    }
}
