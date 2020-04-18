package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {
    private ShapeFactory factory;
    private ColorButton color;
    private ShapesPanel shapesPanel;

    private static final int BORDER = 5;

    public ToolPanel(ShapeFactory factory){
        //set the panel border and layout
        setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setLayout(new BoxLayout(this,
                BoxLayout.LINE_AXIS));
        this.factory = factory;
        //make the color chooser
        colorChooser();
        //add Separator between the color chooser and the radio button area
        addSeparator();

        addShapesPanel();

    }

    /**
     * makes a button that allow the user to choose drawing color
     */
    private void colorChooser() {
        color = new ColorButton(factory);
        add(color);
    }

    /**
     * add vertical separator between items
     */
    private void addSeparator(){
        add(Box.createHorizontalStrut(5));
        add(new JSeparator(JSeparator.VERTICAL));
        add(Box.createHorizontalStrut(5));
    }

    private void addShapesPanel(){
        shapesPanel = new ShapesPanel(factory);
        add(shapesPanel);
    }


}
