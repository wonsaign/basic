package com.learn.java.lang.wangs.base.system;

public class ShowSystem {

    public static void main(String[] args) {
        String[] paths = System.getProperty("java.class.path").split(":");
        for (String p : paths) {
            System.out.println(p);
        }

        //ClassLoader.getResources();
    }
}
