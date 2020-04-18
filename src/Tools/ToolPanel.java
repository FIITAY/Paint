package Tools;

import Shapes.ShapeFactory;

import javax.management.remote.JMXServerErrorException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToolPanel extends JPanel implements ItemListener {
    private ShapeFactory factory;
    private ColorButton color;

    private static final String REC_STR = "Rectangle";
    private static final String ROUND_REC_STR = "Rounded Rectangle";
    private static final String OVAL_STR = "Oval";
    private static final String LINE_STR = "Line";
    private static final int BORDER = 5;

    public ToolPanel(ShapeFactory factory){
        //set the panel border
        setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setLayout(new BoxLayout(this,
                BoxLayout.LINE_AXIS));
        this.factory = factory;
        //make the color chooser
        colorChooser();
        add(Box.createHorizontalStrut(5));
        add(new JSeparator(JSeparator.VERTICAL));
        add(Box.createHorizontalStrut(5));
        ButtonGroup tools = new ButtonGroup();
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        JRadioButton jrb = new JRadioButton(REC_STR,true);
        jrb.addItemListener(this);
        tools.add(jrb);
        radioPanel.add(jrb);
        jrb = new JRadioButton(ROUND_REC_STR,true);
        jrb.addItemListener(this);
        tools.add(jrb);
        radioPanel.add(jrb);
        jrb = new JRadioButton(OVAL_STR,true);
        jrb.addItemListener(this);
        tools.add(jrb);
        radioPanel.add(jrb);
        jrb = new JRadioButton(LINE_STR,true);
        jrb.addItemListener(this);
        tools.add(jrb);
        radioPanel.add(jrb);

        add(radioPanel);

    }

    /**
     * makes a button that allow the user to choose drawing color
     */
    private void colorChooser() {
        color = new ColorButton(factory);
        add(color, BorderLayout.EAST);
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
