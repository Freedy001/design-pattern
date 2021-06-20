package com.freedy.behaviorPattern.strategy;

/**
 * @author Freedy
 * @date 2021/6/18 22:36
 */
public class BStrategy implements Strategy{
    @Override
    public void show() {
        System.out.println("满两百减五十");
    }
}
