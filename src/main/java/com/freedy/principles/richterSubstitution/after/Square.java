package com.freedy.principles.richterSubstitution.after;

/**
 * @author Freedy
 * @date 2021/6/7 23:07
 */
public class Square implements Quadrilateral{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
