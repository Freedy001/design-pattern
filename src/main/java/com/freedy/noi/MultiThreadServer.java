package com.freedy.noi;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Freedy
 * @date 2021/7/2 12:57
 */
public class MultiThreadServer {
    private static final List<Worker> WORKERS = new ArrayList<>();

    static {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++)
            WORKERS.add(new Worker("worker-" + i));
    }

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT, null);
        serverChannel.bind(new InetSocketAddress(1111));
        int counter = 0;
        //noinspection InfiniteLoopStatement
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("client connected--->"+socketChannel.getRemoteAddress());
                    Worker worker = WORKERS.get(counter++ % WORKERS.size());
                    worker.register(socketChannel, SelectionKey.OP_READ);
                }
            }
        }
    }

    static class Worker implements Runnable {
        private Selector selector;
        private final String name;
        private volatile boolean start = false;
        private final Queue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public Worker(String name) {
            this.name = name;
        }

        public void register(SocketChannel channel, int ops) {
            if (!start) {
                synchronized (this) {
                    if (!start) {
                        try {
                            selector = Selector.open();
                            channel.register(selector, ops, null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        new Thread(this, name).start();
                        start = true;
                        return;
                    }
                }
            }
            queue.add(() -> {
                try {
                    channel.register(selector, ops, null);
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                }
            });
            selector.wakeup();
        }


        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while (true) {
                try {
                    selector.select();
                    Runnable task = queue.poll();
                    if (task != null) {
                        task.run();
                    }
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                            List<String> list=new ArrayList<>();
                            while (channel.read(buffer) > 0) {
                                ByteBufferUtil.split(buffer, bytes -> {
                                    String str = new String(bytes);
                                    list.add(str);
                                    System.out.println(str);
                                });
                            }
                            String builder = "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html;charset=utf-8\r\n" +
                                    "Sat, 03 Jul 2021 06:50:14 GMT\r\n" +
                                    "\r\n";
                            channel.write(ByteBuffer.wrap(builder.getBytes(StandardCharsets.UTF_8)));
                            File file = Paths.get("C:\\Users\\Freedy\\Desktop\\资料\\"+list.get(0).split(" ")[1]).toFile();
                            FileChannel rw = new RandomAccessFile(file, "rw").getChannel();
                            rw.transferTo(0,file.length(),channel);
                            channel.close();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
