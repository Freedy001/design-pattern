package com.freedy.builderPattern.builder.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 20:21
 */
public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
