package com.freedy.behaviorPattern.command;

import lombok.AllArgsConstructor;

/**
 * @author Freedy
 * @date 2021/6/18 23:30
 */
@AllArgsConstructor
public class OrderCommand implements Command{
    private final SeniorChef seniorChef;
    private final Order order;

    @Override
    public void execute() {
        System.out.println(order.getTableNum()+"卓的订单:");
        order.getFooDir().forEach(seniorChef::makeFood);
        System.out.println(order.getTableNum()+"的饭准备完毕");
    }
}
