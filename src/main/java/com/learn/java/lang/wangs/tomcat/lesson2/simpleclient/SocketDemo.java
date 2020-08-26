package com.learn.java.lang.wangs.tomcat.lesson2.simpleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {

    @SuppressWarnings("static-access")
    public void sendMsg() {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
            // socket 里 有一个socketImpl 这个socketImpl里有socket,在建立链接的某一个步骤,调用了setSocket将socket放入
            // 这里有一个 设计  就是在socket里有一个 socketImpl 而在socketImpl里又有一个socket 无限递归么
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            pw.println("GET /index.html HTTP/1.1");
            pw.println("Host: localhost:8080");
            pw.println("Connection: Close");
            pw.println();

            StringBuffer sb = new StringBuffer(8096);
            boolean loop = true;
            while (loop) {
                if (br.ready()) {
                    while (br.read() != -1) {
                        sb.append((char) br.read());
                    }
                    loop = false;
                }
                Thread.currentThread().sleep(50);
            }
            System.out.println(sb.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
