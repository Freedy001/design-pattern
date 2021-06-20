package com.freedy.structPattern.decorate;

/**
 * @author Freedy
 * @date 2021/6/18 0:18
 */
public class Test {
    public static void main(String[] args) {
        FastFoot rice = new FriedRice();
        System.out.println(rice.getDesc()+"  "+rice.cost());
        Egg egg = new Egg(rice);
        System.out.println(egg.getDesc()+"  "+egg.cost());
        Egg egg1 = new Egg(egg);
        System.out.println(egg1.getDesc()+"  "+egg1.cost());
        Bacon bacon = new Bacon(egg1);
        System.out.println(bacon.getDesc()+"  "+bacon.cost());
    }
}
