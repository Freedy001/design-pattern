package com.freedy.builderPattern;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author Freedy
 * @date 2021/6/13 23:17
 */
public class Singleton{
    public static void main(String[] args) {
        try {
            Constructor<SinglePattern> constructor = SinglePattern.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SinglePattern a = constructor.newInstance();
            SinglePattern b =  constructor.newInstance();
            System.out.println(a == b);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * 懒汉式 *推荐
 */
class SinglePattern {
    private volatile static SinglePattern instance;

    private SinglePattern() {
    }

    public static SinglePattern getInstance() {
        if (instance == null) {
            synchronized (SinglePattern.class) {
                if (instance == null) { // double check
                    instance = new SinglePattern();
                }
            }
        }
        return instance;
    }

}

/**
 * 懒汉式-静态内部类
 */
class SinglePatternStaticClass {
    private SinglePatternStaticClass() {
    }

    private static class holder {
        private static final SinglePatternStaticClass INSTANCE = new SinglePatternStaticClass();
    }

    public static SinglePatternStaticClass getInstance() {
        return holder.INSTANCE;
    }
}

/**
 * 饿汉式--->枚举实现
 */
enum SinglePatternEnumerate {
    INSTANCE
}

/**
 * 饿汉式 ---> 静态成员变量的方式
 */
class HungryDemo {
    private static final HungryDemo SINGLETON = new HungryDemo();

    private HungryDemo() {
    }

    //提供公共的访问方式
    public static HungryDemo getInstance() {
        return SINGLETON;

    }
}

