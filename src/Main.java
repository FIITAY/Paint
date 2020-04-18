import Painting.DrawingPanel;
import Shapes.*;
import Tools.ToolPanel;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new ToolPanel(new ShapeFactory()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.pack();
        frame.setVisible(true);
    }

    /**public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        JFrame drawingFrame = new JFrame("Draw on me");
        drawingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingFrame.setSize(1000,1000);
        drawingFrame.add(new DrawingPanel(factory), BorderLayout.CENTER);
        drawingFrame.add(new ToolPanel(factory), BorderLayout.SOUTH);
        drawingFrame.setVisible(true);
    }*/
}