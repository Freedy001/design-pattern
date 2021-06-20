package com.freedy.builderPattern.factory.configFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Freedy
 * @date 2021/6/17 17:50
 */
public class Factory {
    private static Map<Object, Object> map;

    static {
        map=new HashMap<>();
        Properties properties = new Properties();
        try {
            properties.load(Factory.class.getClassLoader().getResourceAsStream("bean.properties"));
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                Object bean = Class.forName((String) entry.getValue()).getConstructor().newInstance();
                map.put(entry.getKey(),bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object createBean(String name){
        return map.get(name);
    }
}
