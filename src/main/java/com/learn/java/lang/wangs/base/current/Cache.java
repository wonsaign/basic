package com.learn.java.lang.wangs.base.current;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.learn.java.lang.wangs.base.current.entity.IValue;


public abstract class Cache<K,V> {
	// Future 避免了多个线程同时来取，取值相同
	private final Map<K,Future<V>> cache = new ConcurrentHashMap<>(); // 控制粒度
	
	abstract IValue caculate(K k);

	@SuppressWarnings("unchecked")
	public V getCache(final K k) throws InterruptedException, ExecutionException{
		Future<V> future = cache.get(k);
		if(future == null){
			// 线程去取
			Callable<V> c = new Callable<V>() {
				@Override
				public V call() throws Exception {
					return (V) caculate(k);
				}
			};
			FutureTask<V> ft = new FutureTask<>(c); 
			future = ft; 
			// 取得之后才放入
			cache.put(k, ft);
			ft.run();// 不 run 线程不走了。。。
		}
		return future.get();
	}
	
	public int getSize(){
		return cache.size();
	}
}
