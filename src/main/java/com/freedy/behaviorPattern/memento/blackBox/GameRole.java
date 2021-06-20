package com.freedy.behaviorPattern.memento.blackBox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

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

    public Memento saveState(){
        return new RoleStateMemento(vit,atk,def);
    }

    public void recoverState(Memento memento){
        RoleStateMemento roleStateMemento=(RoleStateMemento)memento;
        vit=roleStateMemento.getVit();
        atk=roleStateMemento.getAtk();
        def=roleStateMemento.getDef();
    }

    public void showState(){
        System.out.println(this);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class RoleStateMemento implements Memento{
        private int vit;
        private int atk;
        private int def;
    }
}
