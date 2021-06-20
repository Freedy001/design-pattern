package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:09
 */
public class test {
    public static void main(String[] args) {
        OperationSystem mac = new Mac(new AviFile());
        mac.play("abc");
    }
}
