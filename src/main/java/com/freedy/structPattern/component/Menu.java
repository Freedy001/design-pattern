package com.freedy.structPattern.component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Freedy
 * @date 2021/6/18 12:38
 */
public class Menu extends MenuComponent{
    private final List<MenuComponent> menuComponents=new ArrayList<>();

    public Menu(String name, int level) {
        super(name, level);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChildMenuComponent(int index) {
        return menuComponents.get(index);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("-------");
        }
        System.out.println(name);
        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }
}
