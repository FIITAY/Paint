import Painting.DrawingPanel;
import Shapes.*;
import Tools.RoundnessPanel;
import Tools.ToolPanel;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        JFrame drawingFrame = new JFrame("Draw on me");
        drawingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingFrame.setSize(1000, 1000);
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingFrame.add(drawingPanel, BorderLayout.CENTER);
        drawingFrame.add(new ToolPanel(drawingPanel.getStackController()), BorderLayout.SOUTH);
        drawingFrame.setVisible(true);
    }
}