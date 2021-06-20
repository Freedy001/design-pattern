package com.freedy.structPattern.facade;

/**
 * @author Freedy
 * @date 2021/6/18 12:17
 */
public class SmartAppliancesFacade {
    private final TV tv=new TV();
    private final Light light=new Light();
    private final AirCondition airCondition=new AirCondition();

    public void say(String msg){
        if ("打开".equals(msg)){
            on();
        }else if ("关闭".equals(msg)){
            off();
        }else {
            System.out.println("你说啥？");
        }
    }

    private void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    private void off(){
        light.off();
        tv.off();
        airCondition.off();
    }

}
