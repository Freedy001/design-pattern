package com.freedy.behaviorPattern.observer;

/**
 * @author Freedy
 * @date 2021/6/19 16:48
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
