package Tools;

import Shapes.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColorButton extends JButton implements ActionListener {
    private ShapeFactory factory;

    private final static int SIZE = 45;
    private final static int Y_OFFSET = 5;
    private JColorChooser colorChooser;

    public ColorButton(ShapeFactory factory) {
        super();
        this.factory = factory;
        addActionListener(this);
        setProperties();
        colorChooser = new JColorChooser();
    }

    /**
     * set the properties of the button to show which color is choosed at all time
     */
    private void setProperties(){
        setBackground(factory.getColor());//import java.awt.Color;
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //set the button size after painting it
        setBounds(SIZE/2, SIZE/2+Y_OFFSET, SIZE, SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get new color from the user
        Color newColor = colorChooser.showDialog(null, "choose shape color", factory.getColor());
        //update the factory to make new shapes with this color only if color was chosen
        if(newColor != null) {
            factory.setColor(newColor);
            //update the color of the button
            setBackground(newColor);
        }
    }
}
