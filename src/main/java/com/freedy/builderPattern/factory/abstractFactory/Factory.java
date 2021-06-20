package com.freedy.builderPattern.factory.abstractFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:51
 */
public interface Factory {
    Coffee createCoffee();
    Dessert createDessert();
}
