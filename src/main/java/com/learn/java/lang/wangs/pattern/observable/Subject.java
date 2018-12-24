package com.learn.java.lang.wangs.pattern.observable;

/**
 * one 
 * @author wangs
 *
 */
public interface Subject {

	void registObs(Observer o);
	void removetObs(Observer o);
	void nofifyObs();
}
