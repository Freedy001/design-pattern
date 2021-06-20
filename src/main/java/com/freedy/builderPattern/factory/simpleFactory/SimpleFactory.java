package com.freedy.builderPattern.factory.simpleFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:06
 */
public class SimpleFactory {
    public static Coffee createCoffee(String type){
        if ("A".equals(type)){
            return new ACoffee();
        }else if ("B".equals(type)){
            return new BCoffee();
        }else throw new RuntimeException();
    }
}
