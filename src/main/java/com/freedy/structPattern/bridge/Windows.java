package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:06
 */
public class Windows extends OperationSystem{
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
