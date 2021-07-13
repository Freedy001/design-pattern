package com.freedy.noi;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Freedy
 * @date 2021/7/2 21:15
 */
@Slf4j
public class AioTest {
    public static void main(String[] args) {
        try (AsynchronousFileChannel channel=AsynchronousFileChannel.open(Paths.get("C:\\Users\\Freedy\\Desktop\\code\\DesignPatterns\\src\\main\\resources\\log4j.properties"), StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(16);
            log.info("read start");
            channel.read(buffer, 0, buffer, new CompletionHandler<>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    log.info("read end");
                    attachment.flip();
                    ByteBufferUtil.debugAll(attachment);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });
            log.info("skip..");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
