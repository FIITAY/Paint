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
        (new MyRoundedRectangle(new Point(10,10), new Point(100,100), Color.RED, true, 60)).draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.add(new Main());
        frame.setVisible(true);
    }
}
