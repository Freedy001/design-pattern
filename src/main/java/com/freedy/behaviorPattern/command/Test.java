package com.freedy.behaviorPattern.command;

/**
 * @author Freedy
 * @date 2021/6/18 23:36
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setTableNum(1);
        order.setFooDir("西红柿",1);
        order.setFooDir("可乐",2);
        Order order2 = new Order();
        order2.setTableNum(2);
        order2.setFooDir("肉丝",1);
        order2.setFooDir("雪碧",2);

        SeniorChef receive = new SeniorChef();
        OrderCommand command1 = new OrderCommand(receive, order);
        OrderCommand command2 = new OrderCommand(receive, order2);
        Waiter waiter = new Waiter();
        waiter.setCommand(command1);
        waiter.setCommand(command2);
        waiter.orderUp();
    }
}
