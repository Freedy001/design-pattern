package com.freedy.builderPattern.factory.abstractFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:52
 */
public class BFactory implements Factory{
    @Override
    public Coffee createCoffee() {
        return new BCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new BDessert();
    }
}
