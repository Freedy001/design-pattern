package com.freedy.structPattern.adapter.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 23:32
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);
        System.out.println("===================");
        String TFmsg = computer.readSD(new SDAdapterTF());
        System.out.println(TFmsg);
    }
}
