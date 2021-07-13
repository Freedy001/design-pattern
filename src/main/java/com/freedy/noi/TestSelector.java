package com.freedy.noi;

import lombok.extern.slf4j.Slf4j;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author Freedy
 * @date 2021/6/30 17:06
 */
@Slf4j
public class TestSelector {
    public static void main(String[] args) throws Throwable {
        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8080));
        socketChannel.configureBlocking(false);
        SelectionKey sscKey = socketChannel.register(selector, 0, null);
        sscKey.interestOps(SelectionKey.OP_ACCEPT);
        System.out.println(sscKey);
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    System.out.println("receive a connection--->" + sc);
                    sc.configureBlocking(false);
                    ByteBuffer buffer = ByteBuffer.allocate(16);
                    SelectionKey scKey = sc.register(selector, 0, buffer);
                    scKey.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    int flag;
                    while ((flag = sc.read(buffer)) > 0) {
                        TestByteBuffer.split(buffer);
                    }
                    if (flag == -1) {
                        System.out.println("disconnect from client<---" + sc);
                        sc.close();
                        key.cancel();
                    }
                }
                iterator.remove();
            }
//            System.out.println("====================INFO===================");
//            System.out.println(selector.keys().size());
//            for (SelectionKey key : selector.keys()) {
//                System.out.println(key);
//            }
//            System.out.println("====================INFO===================");
        }
    }
}
