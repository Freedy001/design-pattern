package com.freedy.builderPattern.builder.demo2;

/**
 * @author Freedy
 * @date 2021/6/17 20:45
 */
public class Test {
    public static void main(String[] args) {
        new Phone.PhoneBuilder()
                .cpu("agda")
                .screen("")
                .mainBoard("")
                .build();
    }
}
