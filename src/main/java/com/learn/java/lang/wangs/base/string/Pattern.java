package com.learn.java.lang.wangs.base.string;

import java.util.HashMap;
import java.util.Map;

public class Pattern {


    /**
     * 正则 去掉内容
     *
     * @param s
     * @return
     */
    private static Map<Integer, String> getElement(String s) {
        String patternCopy = "[\\['('`'){*}'\\]]";
//		String patternCopy = "[\\['(','){*}'\\]]";
        String[] ss = s.split(patternCopy);
        Map<Integer, String> result = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (!"".equals(ss[i])) {
                result.put(i, ss[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "['wangsi'`'hello world']";
        for (Integer ii : getElement(s).keySet()) {
            System.out.println(getElement(s).get(ii));
        }
    }
}
