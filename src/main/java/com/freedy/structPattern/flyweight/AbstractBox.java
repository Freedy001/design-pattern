package com.freedy.structPattern.flyweight;

/**
 * @author Freedy
 * @date 2021/6/18 13:48
 */
public abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color){
        System.out.println("方块形状->"+getShape()+" 颜色->"+color);
    }
}
