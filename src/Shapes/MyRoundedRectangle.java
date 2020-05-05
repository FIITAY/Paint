package Shapes;

import java.awt.*;

/**
 * a rounded rectangle that draws rectangle width rounded corners
 * @author Itay Finci
 */
public class MyRoundedRectangle extends MyBoundedShape {

    int roundnessPercentage;

    /**
     * makes a new rounded rectangle
     * @param origin the point which the rectangle starts in
     * @param target the point which the rectangle ends in
     * @param color the color of the rectangle
     * @param filled if the rectangle is filled or not
     * @param roundnessPercentage the percentage of  the width and height that turns into the arc- between 0 to 100
     * @param thickness the line thickness
     */
    public MyRoundedRectangle(Point origin, Point target, Color color, boolean filled, int roundnessPercentage, int thickness) {
        super(origin, target, color, filled,thickness);
        //the percentage must be between 0 to 100
        if(roundnessPercentage < 0){
            this.roundnessPercentage = 0;
        } else if (roundnessPercentage > 100) {
            this.roundnessPercentage = 100;
        } else {
            this.roundnessPercentage = roundnessPercentage;
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d= (Graphics2D)g;
        //set the color of the graphics to be as the shape color
        g2d.setColor(color);
        g2d.setStroke(stroke);
        //calc the width, height, the rectangle origin, arc length and the arc height of the rectangle
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        int roundWidth = lengthPercentage(width);
        int roundHeight = lengthPercentage(height);
        //check if the rectangle needs to be printed filled or empty
        if(isFilled()) {
            g2d.fillRoundRect(start.x, start.y, width, height ,roundWidth, roundHeight);
        } else {
            g2d.drawRoundRect(start.x, start.y, width, height ,roundWidth, roundHeight);
        }
    }

    /**
     * finds the arc length based on the length and the roundness percentage
     * @param length the width/ height that need to be calculated
     * @return the width/ height of the arc
     */
    private int lengthPercentage(int length) {
        return (int)(length*roundnessPercentage/100.0);
    }
}
