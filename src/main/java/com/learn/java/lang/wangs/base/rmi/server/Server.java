package com.learn.java.lang.wangs.base.rmi.server;

import com.learn.java.lang.wangs.base.rmi.api.LisiSayHelloImpl;
import com.learn.java.lang.wangs.base.rmi.api.SayHello;
import com.learn.java.lang.wangs.base.rmi.api.ZhangsanSayHelloImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * All rights Reserved, Designed By www.drplant.com.cn
 *
 * @ProjectName: basic
 * @Package: com.learn.java.lang.wangs.base.rmi.server
 * @ClassName: Server
 * @Description: []
 * @Author: [wang sai]
 * @Date: 2021/10/18 3:17 下午
 * @Version: V1.0
 * @Copyright: 2019 www.drplant.com.cn Inc. All rights reserved.
 **/
public class Server {

    public static void main(String[] args) {

        try {
            // anonymous port
            SayHello zhangsan = (SayHello) UnicastRemoteObject.exportObject(new ZhangsanSayHelloImpl(), 0);
            SayHello lisi = (SayHello) UnicastRemoteObject.exportObject(new LisiSayHelloImpl(), 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("zhangsan", zhangsan);
            registry.rebind("lisi", lisi);
            System.out.println("SayHello bound");
        } catch (Exception e) {
            System.err.println("SayHello exception:");
            e.printStackTrace();
        }
    }
}
