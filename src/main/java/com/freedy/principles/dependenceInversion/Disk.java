package com.freedy.principles.dependenceInversion;

/**
 * @author Freedy
 * @date 2021/6/7 23:27
 */
public abstract class Disk {
    public void save(){
        System.out.println("硬盘存储数据");
    }
    public String get() {
        return "data";
    }
}
