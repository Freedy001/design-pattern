package com.freedy.behaviorPattern.strategy;

/**
 * @author Freedy
 * @date 2021/6/18 22:36
 */
public class CStrategy implements Strategy{
    @Override
    public void show() {
        System.out.println("满一千加一元换购任意200以下的商品");
    }
}
