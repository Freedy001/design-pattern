package com.freedy.behaviorPattern.observer;

/**
 * @author Freedy
 * @date 2021/6/19 16:53
 */
public class User implements Observer{
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"->"+message);
    }
}
