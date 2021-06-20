package com.freedy.principles.dependenceInversion;

/**
 * @author Freedy
 * @date 2021/6/7 23:27
 */
public class Computer {
    private Disk disk;
    private Cpu cpu;
    private Memory memory;

    public Computer(Disk disk, Cpu cpu, Memory memory) {
        this.disk = disk;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Computer() {
    }

    public void run(){
        System.out.println("boot");
        System.out.println("get data from disk"+disk.get());
        memory.save();
        cpu.run();
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}
