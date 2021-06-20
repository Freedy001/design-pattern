package com.freedy.structPattern.proxy.jdk_Proxy;

/**
 * @author Freedy
 * @date 2021/6/17 21:51
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ProxyFactory factory = new ProxyFactory();
        SellTickets sellTickets = factory.getProxyObject();
        sellTickets.sell();
        System.out.println(sellTickets.getClass());
        Thread.currentThread().join();
    }
}
