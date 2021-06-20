package com.freedy.behaviorPattern.command;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Freedy
 * @date 2021/6/18 23:27
 */
@Data
public class Order {
    private int tableNum;
    private Map<String, Integer> fooDir=new HashMap<>();
    public void setFooDir(String name, Integer num) {
        fooDir.put(name,num);
    }
}
