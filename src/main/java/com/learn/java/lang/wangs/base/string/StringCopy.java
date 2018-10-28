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
}
