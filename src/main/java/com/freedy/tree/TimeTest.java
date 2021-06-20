package com.freedy.tree;

/**
 * @author Freedy
 * @date 2021/6/15 20:55
 */
public class TimeTest {
    public static long time(Runnable runnable){
        long currentTimeMillis = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis()-currentTimeMillis;
    }

    public static void printTime(Runnable runnable){
        System.out.println(time(runnable));
    }

}
