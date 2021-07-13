package com.freedy.noi;

import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Freedy
 * @date 2021/6/30 16:43
 */
@Slf4j
public class ServiceNio {
    static ArrayList<SocketChannel> channels = new ArrayList<>();

    public static void main(String[] args) throws Throwable {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8080));
        ByteBuffer buffer = ByteBuffer.allocate(16);
        socketChannel.configureBlocking(false);
        while (true) {
            SocketChannel channel = socketChannel.accept();
            if (channel != null) {
                log.debug("{}connected...", channel);
                channels.add(channel);
                channel.configureBlocking(false);
            }
            for (SocketChannel channel1 : channels) {
                channel1.read(buffer);
                buffer.flip();
                if (buffer.limit() != 0) {
                    System.out.println(Charset.defaultCharset().decode(buffer));
                }
                buffer.clear();
            }
        }
    }
}
