package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:07
 */
public class Mac extends OperationSystem{
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
