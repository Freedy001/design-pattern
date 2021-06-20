package com.freedy.behaviorPattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/6/19 18:23
 */
public class Home {
    private final List<Animal> nodeList=new ArrayList<>();

    public void add(Animal animal){
        nodeList.add(animal);
    }

    public void action(Person person){
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }
}
