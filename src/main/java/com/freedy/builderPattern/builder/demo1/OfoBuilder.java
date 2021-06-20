package com.freedy.builderPattern.builder.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 20:20
 */
public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setFrame("香蕉座椅");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
