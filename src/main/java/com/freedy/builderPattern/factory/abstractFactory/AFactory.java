package com.freedy.builderPattern.factory.abstractFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:52
 */
public class AFactory implements Factory{
    @Override
    public Coffee createCoffee() {
        return new ACoffee();
    }

    @Override
    public Dessert createDessert() {
        return new ADessert();
    }
}
