package com.freedy.builderPattern.factory.configFactory;

/**
 * @author Freedy
 * @date 2021/6/17 17:49
 */
public class Test {
    public static void main(String[] args) {
        Object aCoffee = Factory.createBean("BCoffee");
        Coffee coffee = (Coffee) aCoffee;
        System.out.println(coffee.getName());
    }
}
