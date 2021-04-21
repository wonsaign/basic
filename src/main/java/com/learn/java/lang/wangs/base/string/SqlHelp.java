package com.learn.java.lang.wangs.base.string;

import java.util.HashMap;
import java.util.Map;

public class SqlHelp {

    public static final String CONDI_AND = "and";
    public static final String CONDI_OR = "or";


    public static void main(String[] args) {

        Map<String, String> complexCondi = new HashMap<>();

        // update(map, "pid=? and uid = ? ", pid , uid);
        Object[] argsss = new Object[]{1, "hello"};
        String condi = "pid=? and name = ? or value = ?";

        String[] split = condi.split("\\?");
        if(containsIngore(split[1], CONDI_OR)){
            complexCondi.put(split[1], CONDI_OR);
        }else if(containsIngore(split[1], CONDI_AND)){
            complexCondi.put(split[1], CONDI_AND);
        }else{
            complexCondi.put(split[1], "");
        }
        System.out.println(containsIngore(split[1], CONDI_OR));
        System.out.println(containsIngore(split[2], CONDI_OR));
        System.out.println(split[0]+ "----" +split[1]);
    }




    public static boolean containsIngore(String src, String t){
        byte[] srcBytes = src.getBytes();
        byte[] tBytes = t.getBytes();
        if(tBytes.length > srcBytes.length){
            return Boolean.FALSE;
        }
        int srcPoint = 0, tPoint = 0;
        for (int i = 0; i < srcBytes.length; i++) {
            if(tPoint == tBytes.length){
                return Boolean.TRUE;
            }
            if(Character.toUpperCase(srcBytes[srcPoint]) == Character.toUpperCase(tBytes[tPoint]) ){
                tPoint++;
            }else {
                tPoint = 0;
            }
            srcPoint++;
        }

        return Boolean.FALSE;
    }
}
