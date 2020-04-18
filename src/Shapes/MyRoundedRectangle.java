package Shapes;

import java.awt.*;

public class MyRoundedRectangle extends MyCompoundShape {

    int roundnessPercentage;

    public MyRoundedRectangle(Point origin, Point target, Color color, boolean filled, int roundnessPercentage) {
        super(origin, target, color, filled);
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
        g.setColor(color);
        int width = calculateWidth();
        int height = calculateHeight();
        Point start = findStart();
        int roundWidth = lengthPercentage(width);
        int roundHeight = lengthPercentage(height);
        if(isFilled()) {
            g.fillRoundRect(start.x, start.y, width, height ,roundWidth, roundHeight);
        } else {
            g.drawRoundRect(start.x, start.y, width, height ,roundWidth, roundHeight);
        }
    }

    private int lengthPercentage(int length) {
        return (int)(length*roundnessPercentage/100.0);
    }
}
