import Painting.DrawingPane;
import Shapes.*;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        DrawingPane dp = new DrawingPane(factory);
        JFrame drawingFrame = new JFrame("Draw on me");
        drawingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingFrame.setSize(1000,1000);
        drawingFrame.add(dp);
        drawingFrame.setVisible(true);
    }
}
