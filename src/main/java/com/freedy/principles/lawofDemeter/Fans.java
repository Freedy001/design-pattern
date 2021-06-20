package com.freedy.principles.lawofDemeter;

/**
 * @author Freedy
 * @date 2021/6/8 0:08
 */
public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
