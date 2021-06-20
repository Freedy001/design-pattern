package com.freedy.builderPattern.factory.configFactory;

/**
 * @author Freedy
 * @date 2021/6/17 16:13
 */
public abstract class Coffee {
    public abstract String getName();

    public void  addMild(){
        System.out.println("加牛奶");
    }

    public void addSugar(){
        System.out.println("加糖");
    }
}
