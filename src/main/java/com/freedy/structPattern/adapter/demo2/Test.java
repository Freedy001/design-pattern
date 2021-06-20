package com.freedy.structPattern.adapter.demo2;


/**
 * @author Freedy
 * @date 2021/6/17 23:32
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCard());
        System.out.println(msg);
        System.out.println("===================");
        String TFmsg = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println(TFmsg);
    }
}
