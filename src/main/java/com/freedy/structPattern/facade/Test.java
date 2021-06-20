package com.freedy.structPattern.facade;

/**
 * @author Freedy
 * @date 2021/6/18 12:20
 */
public class Test {
    public static void main(String[] args) {
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        facade.say("关闭");
    }
}
