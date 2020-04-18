import Shapes.*;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    public Main(){
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MyShape shape = new MyLine(new Point(0,0), new Point(30,20), Color.BLACK);
        shape.draw(g);
        shape = new MyRectangle(new Point(30,20), new Point(0,30), Color.BLUE, true);
        shape.draw(g);
        shape = new MyRectangle(new Point(100,100), new Point(120,130), Color.CYAN, false);
        shape.draw(g);
        shape = new MyOval(new Point(25,40), new Point(60,90), Color.RED, false);
        shape.draw(g);
        shape = new MyOval(new Point(120,130), new Point(150,190), Color.ORANGE, true);
        shape.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
