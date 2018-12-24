package com.learn.java.lang.wangs.base.string;

public final class StringCopy {
//public class StringCopy {	

	private final char value[];
//	private char value[];
	
    
    public StringCopy(String original) {
        this.value = original.toCharArray();
    }

    public void setStringCopy(String original) {
      //  this.value = original.toCharArray();
    	char[] change = original.toCharArray();
    	for (int i = 0; i < value.length; i++) {
			value[i] = change[i];
		}
    }
    
    @Override
    public String toString() {
    	String to = "";
    	for (char c : value) {
			to = to+c;
		}
    	return to;
    }
    public static void main(String[] args) {
    	StringCopy s = null;
    	s = new StringCopy("s1");
    	s = new StringCopy("s2"); 
    	T t1 = new T("t1");
    	t1 = new T("tt1");
    	t1.setV("ttt1");
    	T t2 = new T("t2");
    	t2 = new T("tt2");
    	t2.setV("ttt2");
    }
}
final class T{
	private String v;
	public T(String v) {
		this.v = v;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
}
