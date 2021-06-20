package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:04
 */
public abstract class OperationSystem {
    protected VideoFile videoFile;

    public OperationSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}
