package com.freedy.behaviorPattern.memento.whiteBox;

import lombok.Data;

/**
 * @author Freedy
 * @date 2021/6/19 20:37
 */
@Data
public class GameRole {
    private int vit;
    private int atk;
    private int def;

    public void initState(){
        vit=100;
        atk=100;
        def=100;
    }

    public void fight(){
        vit=0;
        atk=0;
        def=0;
    }

    public RoleStateMemento saveState(){
        return new RoleStateMemento(vit,atk,def);
    }

    public void recoverState(RoleStateMemento roleStateMemento){
        vit=roleStateMemento.getVit();
        atk=roleStateMemento.getAtk();
        def=roleStateMemento.getDef();
    }

    public void showState(){
        System.out.println(this);
    }
}
