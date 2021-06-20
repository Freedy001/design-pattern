package com.freedy.behaviorPattern.memento.blackBox;


/**
 * @author Freedy
 * @date 2021/6/19 20:45
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("----------BEFORE-----------");
        GameRole role = new GameRole();
        role.initState();
        role.showState();
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setMemento(role.saveState());
        System.out.println("----------AFTER-----------");
        role.fight();
        role.showState();
        System.out.println("----------RECOVER-----------");
        Memento memento = caretaker.getMemento();
        role.recoverState(memento);
        role.showState();
    }
}
