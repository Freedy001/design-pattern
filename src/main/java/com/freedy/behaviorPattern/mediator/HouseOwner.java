package com.freedy.behaviorPattern.mediator;

import java.util.Objects;

/**
 * @author Freedy
 * @date 2021/6/19 17:21
 */
public class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void contact(String msg) {
        mediator.contact(msg,this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房主"+name+"获取到的信息是"+message);
    }
}
