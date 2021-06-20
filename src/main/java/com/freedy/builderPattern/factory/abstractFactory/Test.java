package com.freedy.builderPattern.factory.abstractFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:19
 */
public class Test {
    public static void main(String[] args) {
        Factory factory = new BFactory();
        Coffee coffee = factory.createCoffee();
        coffee.addMild();
        coffee.addSugar();
        System.out.println(coffee.getName());
        Dessert dessert = factory.createDessert();
        dessert.show();
    }
}
