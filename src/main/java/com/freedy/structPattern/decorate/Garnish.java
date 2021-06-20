package com.freedy.structPattern.decorate;

import lombok.*;

/**
 * @author Freedy
 * @date 2021/6/18 0:07
 */
@Getter
@Setter
public class Garnish extends FastFoot{
    private FastFoot fastFoot;

    public Garnish(float price, String desc, FastFoot fastFoot) {
        super(price, desc);
        this.fastFoot = fastFoot;
    }

    @Override
    public String getDesc() {
        return super.getDesc()+getFastFoot().getDesc();
    }

    @Override
    public float cost() {
        return getPrice()+ getFastFoot().cost();
    }
}
