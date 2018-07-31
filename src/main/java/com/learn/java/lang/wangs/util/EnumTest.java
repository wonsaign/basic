package com.learn.java.lang.wangs.util;

public enum EnumTest {

	//wang,sai
	wangs("1"),sai("2"){
		@Override
		public String getValue() {
			return super.getValue();
		}
	};
	
	private String value;
	
	private EnumTest(String a){
		
	}
	public String getValue() {
        return value;
    }
}
