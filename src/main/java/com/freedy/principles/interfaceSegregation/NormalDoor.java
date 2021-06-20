package com.freedy.principles.interfaceSegregation;

/**
 * @author Freedy
 * @date 2021/6/7 23:58
 */
public class NormalDoor implements AntiTheft,FireProof {
    @Override
    public void antiTheft() {
        System.out.println("NormalDoor antiTheft");
    }

    @Override
    public void fireProof() {
        System.out.println("NormalDoor fireProof");
    }
}
