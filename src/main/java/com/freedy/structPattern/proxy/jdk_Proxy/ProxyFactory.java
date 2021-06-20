package com.freedy.structPattern.proxy.jdk_Proxy;

import java.lang.reflect.Proxy;

/**
 * @author Freedy
 * @date 2021/6/17 21:35
 */
public class ProxyFactory {
    private final TrainStation station=new TrainStation();

    public SellTickets getProxyObject(){
        return (SellTickets)Proxy.newProxyInstance(station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                (proxy,method,args)->{
                    System.out.println("BEFORE");
                    Object invoke = method.invoke(station,args);
                    System.out.println("AFTER");
                    return invoke;
                });
    }


}
