package com.freedy.structPattern.proxy.staticProxy;

/**
 * @author Freedy
 * @date 2021/6/17 21:30
 */
public class ProxyPoint implements SellTickets{
    private final TrainStation station=new TrainStation();

    @Override
    public void sell() {
        System.out.println("收取代理费！！");
        station.sell();
    }
}
