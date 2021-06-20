package com.freedy.structPattern.bridge;

/**
 * @author Freedy
 * @date 2021/6/18 1:03
 */
public class RmvbFile implements VideoFile{

    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件："+fileName);
    }
}
