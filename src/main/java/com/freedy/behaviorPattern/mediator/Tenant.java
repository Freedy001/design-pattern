package com.freedy.behaviorPattern.mediator;

/**
 * @author Freedy
 * @date 2021/6/19 17:20
 */
public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }
    @Override
    public void contact(String msg){
        mediator.contact(msg,this);
    }
    @Override
    public void getMessage(String message){
        System.out.println("租房者"+name+"获取到的信息是"+message);
    }
}
