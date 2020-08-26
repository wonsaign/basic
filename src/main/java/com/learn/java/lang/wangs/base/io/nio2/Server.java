package com.learn.java.lang.wangs.base.io.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {
    private ExecutorService taskExecutor;
    private AsynchronousServerSocketChannel serverChannerl;

    class Worker implements Callable<String> {
        private CharBuffer charBuffer;
        private CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
        private AsynchronousSocketChannel channel;

        Worker(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }


        @Override
        public String call() throws Exception {
            final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (channel.read(buffer).get() != -1) {
                buffer.flip();
                charBuffer = decoder.decode(buffer);
                String request = charBuffer.toString().trim();
                System.out.println("客户端请求：" + request);
                ByteBuffer outBuffer = ByteBuffer.wrap("请求收到".getBytes());
                channel.write(outBuffer).get();
                if (buffer.hasRemaining()) {
                    buffer.compact();
                } else {
                    buffer.clear();
                }
            }
            channel.close();
            return "ok";
        }

    }

    // channel 准备
    public void init() throws IOException {
        taskExecutor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        serverChannerl = AsynchronousServerSocketChannel.open();
        if (serverChannerl.isOpen()) {
            serverChannerl.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            serverChannerl.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            serverChannerl.bind(new InetSocketAddress("127.0.0.1", 8080));
        } else {
            throw new RuntimeException("通道未打开");
        }
    }

    public void start() {
        System.out.println("等待客户端请求。。。");
        while (true) {
            Future<AsynchronousSocketChannel> future = serverChannerl.accept();
            try {
                AsynchronousSocketChannel channel = future.get();
                taskExecutor.submit(new Worker(channel));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("服务器关闭！");
                taskExecutor.shutdown();
                while (!taskExecutor.isTerminated()) {
                    //NOP
                }
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.init();
        server.start();
    }
}
