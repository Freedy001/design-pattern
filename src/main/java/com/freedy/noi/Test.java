package com.freedy.noi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.nio.channels.FileChannel;

/**
 * @author Freedy
 * @date 2021/6/29 21:12
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        try (
                FileChannel channel = new FileInputStream("C:\\Users\\Freedy\\Desktop\\code\\DesignPatterns\\haha.txt").getChannel();
                FileChannel out = new FileOutputStream("D:\\视频图片素材\\Test.txt").getChannel()
        ) {
            for (long size = channel.size(), i = size; i > 0; ) {
                i -= channel.transferTo(size - i, i, out);
            }
        } catch (IOException ignore) {
        }

    }
}
