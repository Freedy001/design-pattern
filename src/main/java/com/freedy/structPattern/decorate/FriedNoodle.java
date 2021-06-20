package com.freedy.structPattern.decorate;

/**
 * @author Freedy
 * @date 2021/6/18 0:06
 */
public class FriedNoodle extends FastFoot{
    public FriedNoodle() {
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
