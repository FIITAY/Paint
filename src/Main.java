import Painting.DrawingPanel;
import Shapes.*;
import Tools.ToolPanel;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        JFrame drawingFrame = new JFrame("Draw on me");
        drawingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingFrame.setSize(1000,1000);
        drawingFrame.add(new DrawingPanel(factory));
        drawingFrame.setVisible(true);
        JFrame toolPane = new JFrame("tools");
        toolPane.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        toolPane.setSize(100,1000);
        toolPane.setLocation(1000,0);
        toolPane.add(new ToolPanel(factory));
        toolPane.setVisible(true);
    }
}
