package com.freedy.builderPattern.factory.simpleFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:20
 */
public class Test {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("A");
        System.out.println(coffee.getName());
    }
}
