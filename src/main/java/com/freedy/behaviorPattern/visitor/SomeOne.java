package com.freedy.behaviorPattern.visitor;

/**
 * @author Freedy
 * @date 2021/6/19 18:22
 */
public class SomeOne implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂狗");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("其他人为毛");
    }
}
