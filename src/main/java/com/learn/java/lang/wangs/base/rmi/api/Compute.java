package com.learn.java.lang.wangs.base.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wangsai
 */
public interface Compute extends Remote {
    /**
     * @param t
     * @param <T>
     * @return
     * @throws RemoteException
     */
    <T> T executeTask(Task<T> t) throws RemoteException;
}
