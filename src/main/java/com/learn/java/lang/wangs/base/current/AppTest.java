package com.learn.java.lang.wangs.base.current;

import java.util.concurrent.ExecutionException;

import com.learn.java.lang.wangs.base.current.entity.IValue;
import com.learn.java.lang.wangs.base.current.entity.Kentend;
import com.learn.java.lang.wangs.base.current.entity.Ventend;

public class AppTest{
	
	public static Cache<Kentend,Ventend> c;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		for (int i = 0; i < 100; i++) {
			final Kentend k = new Kentend();
			k.setK(i);
//			Ventend v  = T(k);
//			System.out.println(v.getV());
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Ventend v  = T(k);
						System.out.println(v.getV());
					} catch (InterruptedException e) {
					} catch (ExecutionException e) {
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Ventend v  = T(k);
						System.out.println(v.getV());
					} catch (InterruptedException e) {
					} catch (ExecutionException e) {
					}
				}
			}).start();
			
		}
		
	}
	
	static Ventend T(Kentend k) throws InterruptedException, ExecutionException{
		if(c == null){
			c = new Cache<Kentend, Ventend>(){
				@Override
				IValue caculate(Kentend k) {
					return Ventend.getVentend(k);
				}};
		}
		return c.getCache(k);
	}

}
