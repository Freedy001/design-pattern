package com.freedy.structPattern.component;

import lombok.AllArgsConstructor;

/**
 * @author Freedy
 * @date 2021/6/18 12:34
 */
@AllArgsConstructor
public abstract class MenuComponent {
    protected String name;
    protected int level;

    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChildMenuComponent(int index){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        return name;
    }
    public abstract void print();

}
