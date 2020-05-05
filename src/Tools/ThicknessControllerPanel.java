package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ThicknessControllerPanel extends JPanel implements ChangeListener {

    private static final String LABEL_STR = "Line Thickness:";

    private JLabel label;
    private JSlider thickness;

    public ThicknessControllerPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel(LABEL_STR);
        add(label);
        makeSlider();
    }

    private void makeSlider(){
        thickness = new JSlider(1,50,ShapeFactory.getThickness());
        thickness.addChangeListener(this);
        thickness.setPaintLabels(true);
        thickness.setMinorTickSpacing(5);
        thickness.setMajorTickSpacing(10);
        add(thickness);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        ShapeFactory.setThickness(source.getValue());
    }
}
