package com.freedy.behaviorPattern.visitor;

/**
 * @author Freedy
 * @date 2021/6/19 18:21
 */
public class Owner implements Person{
    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂狗");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂毛");
    }
}
