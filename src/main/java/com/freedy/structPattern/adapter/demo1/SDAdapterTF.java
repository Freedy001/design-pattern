package com.freedy.structPattern.adapter.demo1;

/**
 * @author Freedy
 * @date 2021/6/17 23:33
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{

    @Override
    public String readSD() {
        System.out.println("经过适配器");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("经过适配器");
        writeTF(msg);
    }
}
