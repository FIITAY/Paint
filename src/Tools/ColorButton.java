package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton implements ActionListener {
    private Color myColor;
    private ShapeFactory factory;

    public ColorButton(ShapeFactory factory) {
        super();
        myColor = factory.getColor();
        this.factory = factory;
        addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //i'm not calling super.paintComponent because i dont want the default look.
        g.setColor(myColor);
        g.fillRect(0,0,30,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color newColor = JColorChooser.showDialog(null, "choose shape color", factory.getColor());
        factory.setColor(newColor);
        myColor = newColor;
        repaint();
    }
}
