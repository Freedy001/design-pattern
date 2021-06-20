package com.freedy.behaviorPattern.strategy;

/**
 * @author Freedy
 * @date 2021/6/18 22:39
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new CStrategy());
        context.sailsManShow();
    }
}
