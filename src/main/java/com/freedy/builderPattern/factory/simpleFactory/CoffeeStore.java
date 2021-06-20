package com.freedy.builderPattern.factory.simpleFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:19
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type){
        Coffee coffee = SimpleFactory.createCoffee(type);
        coffee.addMild();
        coffee.addSugar();
        return coffee;
    }
}
