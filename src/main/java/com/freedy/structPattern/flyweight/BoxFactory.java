package com.freedy.structPattern.flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Freedy
 * @date 2021/6/18 13:50
 */
public class BoxFactory {
    private static volatile BoxFactory factory;
    private final Map<String, AbstractBox> container;
    private BoxFactory(){
        Map<String, AbstractBox> container=new HashMap<>();
        container.put("I",new IBox());
        container.put("L",new LBox());
        container.put("O",new OBox());
        container.put("Z",new ZBox());
        this.container=container;
    }

    public static BoxFactory getFactory(){
        if (factory==null){
            synchronized (BoxFactory.class){
                if (factory==null) factory=new BoxFactory();
            }
        }
        return factory;
    }

    public AbstractBox getBox(String name){
        return container.get(name);
    }

}
