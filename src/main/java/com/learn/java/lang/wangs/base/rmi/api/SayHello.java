package com.learn.java.lang.wangs.base.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SayHello extends Remote {

    void sayHello() throws RemoteException;
}
