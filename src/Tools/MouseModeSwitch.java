package Tools;

import Painting.MouseController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseModeSwitch extends JToggleButton {

    private static final String CLICK_TEXT = "Click!";
    private static final String DRAG_TEXT = "Drag!";

    private MouseController.MouseMode curMode;

    public MouseModeSwitch(){
        super(CLICK_TEXT, false);
        curMode = MouseController.getCurrentMode();
        updateText();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                curMode = MouseController.toggleMode();
                updateText();
                repaint();
            }
        });
    }

    private void updateText(){
        switch (curMode){
            case DRAG:
                setText(DRAG_TEXT);
                break;
            case CLICK:
                setText(CLICK_TEXT);
                break;
            default:
                break;
        }
    }
}
