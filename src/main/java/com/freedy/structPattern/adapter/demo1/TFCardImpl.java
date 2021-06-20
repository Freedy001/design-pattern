package com.freedy.structPattern.adapter.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 23:27
 */
public class TFCardImpl implements TFCard{

    @Override
    public String readTF() {
        return "TF-card read msg : hello !!!";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TF-card write msg :"+msg);
    }
}
