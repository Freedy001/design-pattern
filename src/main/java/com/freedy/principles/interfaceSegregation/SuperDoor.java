package com.freedy.principles.interfaceSegregation;

/**
 * @author Freedy
 * @date 2021/6/7 23:57
 */
public class SuperDoor implements AntiTheft,FireProof,WaterProof {

    @Override
    public void antiTheft() {
        System.out.println("antiTheft");
    }

    @Override
    public void fireProof() {
        System.out.println("fireProof");
    }

    @Override
    public void waterProof() {
        System.out.println("waterProof");
    }
}
