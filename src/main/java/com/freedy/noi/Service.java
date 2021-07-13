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
 * @date 2021/6/29 23:59
 */
@Slf4j
public class Service {
    public static void main(String[] args) throws Throwable{
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8080));
        ByteBuffer buffer = ByteBuffer.allocate(16);
        ArrayList<SocketChannel> channels = new ArrayList<>();
        while (true){
            log.debug("connecting...");
            SocketChannel channel = socketChannel.accept();
            log.debug("connected...{}",channel);
            channels.add(channel);
            for (SocketChannel channel1 : channels) {
                log.debug("before read...{}",channel1);
                channel1.read(buffer);
                buffer.flip();
                System.out.println(Charset.defaultCharset().decode(buffer));
                buffer.clear();
                log.debug("after read...{}",channel1);
            }
        }
    }
}
