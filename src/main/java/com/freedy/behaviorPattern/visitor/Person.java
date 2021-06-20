package com.freedy.behaviorPattern.visitor;

/**
 * @author Freedy
 * @date 2021/6/19 18:18
 */
public interface Person {
    void feed(Dog dog);
    void feed(Cat cat);
}
