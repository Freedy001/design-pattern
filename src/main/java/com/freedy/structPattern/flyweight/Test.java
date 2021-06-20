package com.freedy.structPattern.flyweight;

import javax.swing.*;

/**
 * @author Freedy
 * @date 2021/6/18 13:55
 */
public class Test {
    public static void main(String[] args) {
        BoxFactory factory = BoxFactory.getFactory();
        AbstractBox box = factory.getBox("I");
        box.display("黄色");
    }
}
