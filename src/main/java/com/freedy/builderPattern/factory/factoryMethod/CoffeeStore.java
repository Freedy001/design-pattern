package com.freedy.builderPattern.factory.factoryMethod;

/**
 * @author Freedy
 * @date 2021/6/17 16:19
 */
public class CoffeeStore {
    public Coffee orderCoffee(CoffeeFactory factory){
        Coffee coffee = factory.createCoffee();
        coffee.addMild();
        coffee.addSugar();
        return coffee;
    }
}
