package com.freedy.noi;

import java.nio.ByteBuffer;

/**
 * @author Freedy
 * @date 2021/7/1 0:19
 */
public class TestCompact {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put("abcde".getBytes());
        buffer.put("a".getBytes());
        buffer.flip();
        buffer.get();
        buffer.get();
        buffer.get();
        buffer.compact();
        System.out.println(buffer);
    }
}
