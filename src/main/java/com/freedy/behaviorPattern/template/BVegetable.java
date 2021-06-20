package com.freedy.behaviorPattern.template;

/**
 * @author Freedy
 * @date 2021/6/18 22:12
 */
public class BVegetable extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("才行");
    }

    @Override
    public void pourSauce() {
        System.out.println("粗");
    }
}
