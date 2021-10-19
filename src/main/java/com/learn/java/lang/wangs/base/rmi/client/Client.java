package com.learn.java.lang.wangs.base.rmi.client;

import com.learn.java.lang.wangs.base.rmi.api.SayHello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author wangsai
 */
public class Client {

    public static void main(String args[]) {
        try {
//            String name = "SayHello";
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            SayHello zhangsan = (SayHello) registry.lookup("zhangsan");
            zhangsan.sayHello();

            SayHello lisi = (SayHello) registry.lookup("lisi");
            lisi.sayHello();
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }

}
