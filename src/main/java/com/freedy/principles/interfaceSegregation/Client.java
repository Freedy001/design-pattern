package com.freedy.principles.interfaceSegregation;

/**
 * @author Freedy
 * @date 2021/6/7 23:59
 */
public class Client {
    public static void main(String[] args) {
        NormalDoor door = new NormalDoor();
        door.antiTheft();
        door.fireProof();
        SuperDoor superDoor = new SuperDoor();
        superDoor.antiTheft();
        superDoor.waterProof();
        superDoor.fireProof();
    }
}
