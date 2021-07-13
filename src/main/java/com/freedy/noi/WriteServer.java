package com.freedy.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author Freedy
 * @date 2021/7/2 10:34
 */
public class WriteServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        ssc.bind(new InetSocketAddress(8080));
        while (true) {
            selector.select();
            System.out.println("====");
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ssc.accept();
                    socketChannel.configureBlocking(false);
                    SelectionKey scKey = socketChannel.register(selector, 0, null);
                    ByteBuffer buffer = Charset.defaultCharset().encode("a".repeat(3_000_000));
                    System.out.println("发送消息...");
                    int write = socketChannel.write(buffer);
                    System.out.println(write);
                    if (buffer.hasRemaining()) {
                        scKey.interestOps(scKey.interestOps() | SelectionKey.OP_WRITE);
                        scKey.attach(buffer);
                    }
                } else if (key.isWritable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    System.out.println("发送剩余消息...");
                    int write = channel.write(buffer);
                    System.out.println(write);
                    if (!buffer.hasRemaining()) {
                        channel.close();
                        key.cancel();
                    }
                }
            }
        }
    }
}
