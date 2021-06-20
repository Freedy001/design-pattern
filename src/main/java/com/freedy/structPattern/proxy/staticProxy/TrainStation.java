package com.freedy.structPattern.proxy.staticProxy;

/**
 * @author Freedy
 * @date 2021/6/17 21:29
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
