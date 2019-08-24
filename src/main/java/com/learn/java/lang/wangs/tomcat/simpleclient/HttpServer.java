package com.learn.java.lang.wangs.tomcat.simpleclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class HttpServer {

    static public final String WEB_ROOT = System.getProperty("user.dir") + java.io.File.separator +
            "webroot";
    
    private boolean shutdown = false;
    
    static private final String SHUTDOWN_COMMAND = "/shutdown";
    
    public static void main(String[] args) {
        System.err.println("starting");
        HttpServer hs = new HttpServer();
        hs.await();
    }
    
    private void await() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while(!shutdown) {
            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;
            
            try {
                socket = server.accept();
                in = socket.getInputStream();
                out = socket.getOutputStream();
                
                Request request = new Request(in);
                request.parse();
                
                Response response = new Response(out);
                response.setRequest(request);
                response.sendStaticResource();
                
                socket.close();
                
                // shutdown = true;
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}
