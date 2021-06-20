package com.freedy.structPattern.decorate;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Freedy
 * @date 2021/6/18 0:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FriedRice extends FastFoot{
    public FriedRice(){
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
