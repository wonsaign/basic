package com.learn.java.lang.wangs.base.string;

import java.util.regex.Matcher;

/**
 * @author wangsai
 */
public class RegexTest {

    public static void main(String[] args) {
        System.out.println(regexContent("[a-zA-Z][\\d\\w_-]{6,20}", "x1032180812"));
        System.out.println(regexContent("[a-zA-Z][\\d\\w_-]{6,20}", "xxssiaog+fenfeng"));

        System.out.println(completeMatched("[a-zA-Z][\\d\\w_-]{6,20}", "x1032180812"));
        System.out.println(completeMatched("[a-zA-Z][\\d\\w_-]{6,20}", "xxssiaog+fenfeng"));
    }

    private static String regexContent(String regexStr, String words){
        if(regexStr != null && regexStr.length() > 0){
            Matcher matcherD = java.util.regex.Pattern.compile(regexStr).matcher(words);
            while (matcherD.find()){
                //System.out.println(matcherD.group());
                return matcherD.group();
            }
        }
        return "";
    }

    private static boolean completeMatched(String regexStr, String words){
        if(regexStr != null && regexStr.length() > 0){
            Matcher matcherD = java.util.regex.Pattern.compile(regexStr).matcher(words);
            while (matcherD.find()){
                if(words.length() == matcherD.group().length()){
                    return true;
                }
            }
        }
        return false;
    }
}
