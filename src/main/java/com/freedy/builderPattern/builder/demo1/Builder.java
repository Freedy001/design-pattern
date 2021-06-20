package com.freedy.builderPattern.builder.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 20:17
 */
public abstract class Builder {
    protected Bike bike=new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();

}
