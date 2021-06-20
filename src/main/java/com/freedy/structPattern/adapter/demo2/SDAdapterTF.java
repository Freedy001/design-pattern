package com.freedy.structPattern.adapter.demo2;


/**
 * @author Freedy
 * @date 2021/6/17 23:33
 */
public class SDAdapterTF extends SDCard{

    private final TFCardImpl tfCard;

    public SDAdapterTF(TFCardImpl tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("经过适配器");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("经过适配器");
        tfCard.writeTF(msg);
    }
}
