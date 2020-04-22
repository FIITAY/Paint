package Tools;

import Painting.StackController;
import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {
    private ColorButton color;
    private ShapesPanel shapesPanel;
    private SettingPanel settingPanel;
    private ControlPanel controlPanel;

    private static final int BORDER = 5;

    public ToolPanel(StackController stackController){
        //set the panel border and layout
        setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
        setLayout(new BoxLayout(this,
                BoxLayout.LINE_AXIS));
        addPanels(stackController);
    }

    /**
     * makes all of the panels and add them to this panel
     * @param stackController object that controls the shape stack
     */
    private void addPanels(StackController stackController){
        addColorChooser();
        addSeparator();
        addShapesPanel();
        addSeparator();
        addSettingsPanel();
        addSeparator();
        addControlPanel(stackController);
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

    /**
     * add the panel that allows to do undo,clear,exit and more
     * @param stackController the object  that can send commands to the shape stack
     */
    private void addControlPanel(StackController stackController) {
        controlPanel = new ControlPanel(stackController);
        add(controlPanel);
    }

}
