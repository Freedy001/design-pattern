package com.freedy.noi;

import java.nio.ByteBuffer;
import java.util.*;


/**
 * @author Freedy
 * @date 2021/6/29 21:57
 */
public class TestByteBuffer {
    static List<Byte> charBuffer = new ArrayList<>(32);

    public static void main(String[] args) throws Throwable {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        byteBuffer.put("hello,world\nI'm zhangsan\nho".getBytes());
        split(byteBuffer);
        byteBuffer.put("w are you?\n".getBytes());
        split(byteBuffer);
    }

    public static void split(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == '\n') {
                byte[] buf = new byte[charBuffer.size()];
                for (int n = 0; n<charBuffer.size(); n++) {
                    buf[n] = charBuffer.get(n);
                }
                System.out.println(new String(buf));
                charBuffer.clear();
            } else {
                charBuffer.add(b);
            }
        }
        byteBuffer.clear();
    }
}
