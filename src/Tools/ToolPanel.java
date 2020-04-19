package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {
    private ColorButton color;
    private ShapesPanel shapesPanel;
    private SettingPanel settingPanel;

    private static final int BORDER = 5;

    public ToolPanel(){
        //set the panel border and layout
        setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setLayout(new BoxLayout(this,
                BoxLayout.LINE_AXIS));
        //make the color chooser
        addColorChooser();
        //add Separator between the color chooser and the radio button area
        addSeparator();
        addShapesPanel();
        addSeparator();
        addSettingsPanel();
    }

    /**
     * makes a button that allow the user to choose drawing color
     */
    private void addColorChooser() {
        color = new ColorButton();
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

    /**
     * add the panel that allows to change what shape is drawn
     */
    private void addShapesPanel(){
        shapesPanel = new ShapesPanel();
        add(shapesPanel);
    }

    /**
     * add the panel that allows you to change extra settings
     */
    private void addSettingsPanel() {
        settingPanel = new SettingPanel();
        add(settingPanel);
    }


}
