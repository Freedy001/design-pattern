package com.freedy.noi;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Freedy
 * @date 2021/6/29 23:18
 */
public class TestPath {
    public static void main(String[] args) throws IOException {
        String source="D:\\视频图片素材\\HYPERLAPSE";
        String target="D:\\视频图片素材\\TEST";
        showFile(Paths.get(target).toFile());
//        Files.walk(Paths.get(source)).forEach(pa->{
//            try {
//                String targetName=pa.toString().replace(source,target);
//                if (Files.isDirectory(pa)){
//                    System.out.println("====>"+pa);
//                    Files.createDirectory(Paths.get(targetName));
//                }
//                else if (Files.isRegularFile(pa)){
//                    System.out.println(pa);
//                    Files.copy(pa,Paths.get(targetName));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
    public static void showFile(File file){
        File[] files = file.listFiles();
        if (files ==null) return;
        for (File listFile : files) {
            System.out.println(listFile.getName());
            showFile(listFile);
            listFile.delete();
        }
    }
}
