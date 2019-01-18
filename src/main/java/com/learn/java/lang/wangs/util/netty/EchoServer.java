package com.learn.java.lang.wangs.util.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer{

    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        // if(args.length != 1){
        //     System.err.println("Usage"+ EchoServer.class.getSimpleName()+ "<port>");
        // }
        // int port = Integer.parseInt(args[0]);
        new EchoServer(8989).start();
    }

    public void start() throws Exception {
        final EchoServiceHandle serverHander = new EchoServiceHandle();
        EventLoopGroup group = new NioEventLoopGroup();
        
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
            .channel(NioServerSocketChannel.class)
            .localAddress(new InetSocketAddress(port))
            .childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(serverHander);
                }
            });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } finally{
            group.shutdownGracefully().sync(); 
        }

    }
}