package com.freedy.builderPattern.builder.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 20:23
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        Bike bike = director.construct();
        System.out.println(bike);
    }
}
