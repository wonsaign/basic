package com.learn.java.lang.wangs.base.rmi.demo;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author wangsai
 */
public class ComputePi {

    public static void main(String args[]) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi();
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }

}
