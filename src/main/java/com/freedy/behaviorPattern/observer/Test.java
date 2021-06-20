package com.freedy.behaviorPattern.observer;

/**
 * @author Freedy
 * @date 2021/6/19 16:55
 */
public class Test {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new User("小明"));
        subject.attach(new User("老王"));
        subject.attach(new User("shun悟空"));
        subject.notify("发布问章喏");
    }
}
