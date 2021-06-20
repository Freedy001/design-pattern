package com.freedy.behaviorPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/19 16:51
 */
public class SubscriptionSubject implements Subject{

    private final List<Observer> observers=new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
