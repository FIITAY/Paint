import KeyBoard.KeyBoardManager;
import Painting.DrawingPanel;
import Painting.StackController;
import Tools.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main{

    public static void main(String[] args) {
        JFrame drawingFrame = new JFrame("Draw on me");
        drawingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingFrame.setSize(1000, 1000);
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingFrame.add(drawingPanel, BorderLayout.CENTER);
        StackController sc = drawingPanel.getStackController();
        ToolPanel tp = new ToolPanel(sc);
        drawingFrame.add(tp, BorderLayout.SOUTH);
        shortcuts(sc);
        drawingFrame.setVisible(true);
    }

    private static void shortcuts(StackController sc){
        KeyboardFocusManager keyManager;

        keyManager=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyManager.addKeyEventDispatcher(new KeyBoardManager(sc));
    }
}