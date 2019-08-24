package com.learn.java.lang.wangs.tomcat.simpleclient;

import java.io.IOException;
import java.io.InputStream;

public class Request {

    private InputStream input;
    private String uri;
    
    public Request(InputStream input) {
        super();
        this.input = input;
    }
    
    
    public InputStream getInput() {
        return input;
    }
    public void setInput(InputStream input) {
        this.input = input;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public void parse() {
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[2048];
        int i;
        try {
           i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            sb.append((char)buffer[j]);
        }
        System.out.println(sb.toString());
        uri = praseUri(sb.toString());
    }
    
    private String praseUri(String s) {
        int i1,i2;
        i1 = s.indexOf(' ');
        if(i1 != -1) {
            i2 = s.indexOf(' ', i1 + 1);
            if(i2 > i1) {
                return s.substring(i1 + 1, i2);
            }
        }
        return null;
    }
}
