package com.learn.java.lang.wangs.rebuild;

class Person{
	private Money money;
	
	public Person(double hasMoney) {
		money = new Money(hasMoney);
	}
	public Money getMoney() {
		return money;
	}
	public void setMoney(double hasMoney) {
		money = new Money(hasMoney);
	}
}

class Money{
	private double renminbi;
	
	public Money(double hasMoney) {
		this.renminbi = hasMoney;
	}
	public double getRenminbi() {
		return this.renminbi;
	}
	// TODO: equals 判断保证值对象唯一
}

public class ValueToRe {

}
