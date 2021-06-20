package com.freedy.structPattern.adapter.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 23:29
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        return "SD-card read msg hello";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SD-card write msg:="+msg);
    }
}
