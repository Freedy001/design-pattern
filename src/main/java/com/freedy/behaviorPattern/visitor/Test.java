package com.freedy.behaviorPattern.visitor;

/**
 * @author Freedy
 * @date 2021/6/19 18:25
 */
public class Test {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());
        Owner owner = new Owner();
        home.action(owner);
        home.action(new SomeOne());
    }
}
