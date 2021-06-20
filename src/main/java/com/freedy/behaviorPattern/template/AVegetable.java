package com.freedy.behaviorPattern.template;

/**
 * @author Freedy
 * @date 2021/6/18 22:12
 */
public class AVegetable extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("包材");
    }

    @Override
    public void pourSauce() {
        System.out.println("辣椒");
    }
}
