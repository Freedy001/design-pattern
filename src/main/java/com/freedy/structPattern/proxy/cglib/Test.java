package com.freedy.structPattern.proxy.cglib;

/**
 * @author Freedy
 * @date 2021/6/17 22:53
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ProxyFactory factory = new ProxyFactory();
        TrainStation obj = factory.getProxyObj();
        obj.sell();
        System.out.println(obj.getClass());
        Thread.currentThread().join();
    }
}
