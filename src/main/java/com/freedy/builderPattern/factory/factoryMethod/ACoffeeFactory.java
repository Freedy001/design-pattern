package com.freedy.builderPattern.factory.factoryMethod;

/**
 * @author Freedy
 * @date 2021/6/17 16:31
 */
public class ACoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new ACoffee();
    }
}
