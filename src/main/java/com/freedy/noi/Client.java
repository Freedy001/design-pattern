package com.freedy.noi;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Freedy
 * @date 2021/6/30 0:07
 */
public class Client {
    public static void main(String[] args) throws Throwable {
        SocketChannel open = SocketChannel.open();
        open.connect(new InetSocketAddress("www.baidu.com",80));
        open.write(StandardCharsets.UTF_8.encode("GET / HTTP/1.1\r\n"));
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 10);
        open.read(buffer);
        System.out.println("waiting...");
        System.out.println(Charset.defaultCharset().decode(buffer));
    }
}
