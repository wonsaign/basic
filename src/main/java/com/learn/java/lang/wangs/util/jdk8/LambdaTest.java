package com.learn.java.lang.wangs.util.jdk8;

@FunctionalInterface
interface Interf {
//	void sayInterWorld(String str);
	String answerYourQues();
}
public class LambdaTest {
	public static void main(String[] args) {
		iT(()->"hi");
//		iT((s)->{});
	}
	static Interf iT(Interf i) {
		return i;
	}
}
