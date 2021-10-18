package com.learn.java.lang.wangs.base.rmi.server;


import com.learn.java.lang.wangs.base.rmi.api.Compute;
import com.learn.java.lang.wangs.base.rmi.api.Task;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author wangsai
 */
public class ComputeEngine implements Compute {

    public ComputeEngine() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {

//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            // anonymous port
            Compute stub =
                    (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

}
