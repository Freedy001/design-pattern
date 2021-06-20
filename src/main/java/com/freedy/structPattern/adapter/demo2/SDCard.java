package com.freedy.structPattern.adapter.demo2;

/**
 * @author Freedy
 * @date 2021/6/17 23:29
 */
public class SDCard{

    public String readSD() {
        return "SD-card read msg hello";
    }


    public void writeSD(String msg) {
        System.out.println("SD-card write msg:="+msg);
    }
}
