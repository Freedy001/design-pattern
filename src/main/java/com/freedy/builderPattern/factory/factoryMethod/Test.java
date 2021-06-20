package com.freedy.builderPattern.factory.factoryMethod;


/**
 * @author Freedy
 * @date 2021/6/17 16:33
 */
public class Test {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee(new ACoffeeFactory());
        System.out.println(coffee.getName());
    }
}
