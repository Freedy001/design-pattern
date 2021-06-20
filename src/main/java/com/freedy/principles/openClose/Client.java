package com.freedy.principles.openClose;

/**
 * @author Freedy
 * @date 2021/6/6 23:02
 */
public class Client {
    public static void main(String[] args) {
        SouGouInput input = new SouGouInput();
        input.setSkin(new MySkin());
        input.display();
    }
}
