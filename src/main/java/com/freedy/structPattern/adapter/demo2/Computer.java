package com.freedy.structPattern.adapter.demo2;

/**
 * @author Freedy
 * @date 2021/6/17 23:31
 */
public class Computer {
    public String readSD(SDCard sdCard){
        if (sdCard==null) throw new NullPointerException("SD card can not be null");
        return sdCard.readSD();
    }
}
