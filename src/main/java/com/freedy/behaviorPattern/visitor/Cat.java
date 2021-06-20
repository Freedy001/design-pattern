package com.freedy.behaviorPattern.visitor;

/**
 * @author Freedy
 * @date 2021/6/19 18:19
 */
public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，喵喵喵");
    }
}
