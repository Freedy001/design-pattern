package com.freedy.principles.lawofDemeter;

/**
 * @author Freedy
 * @date 2021/6/8 0:07
 */
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
