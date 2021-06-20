package com.freedy.principles.dependenceInversion;


/**
 * @author Freedy
 * @date 2021/6/7 23:31
 */
public class Test {
    public static void main(String[] args) {
        Disk myDisk = new Disk() {};
        Cpu cpu = new Cpu() {};

        Memory myMemory = new Memory() {
            @Override
            public void save() {
                System.out.println("super memory is booting...");
            }
        };

        Computer computer = new Computer(myDisk,cpu,myMemory);
        computer.run();

    }
}
