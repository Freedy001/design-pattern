package com.freedy.principles.openClose;

/**
 * @author Freedy
 * @date 2021/6/6 22:45
 */
public class SouGouInput {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
