package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:02
 */
public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件："+fileName);
    }
}
