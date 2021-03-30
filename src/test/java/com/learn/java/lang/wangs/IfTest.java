package com.learn.java.lang.wangs;

public class IfTest {

    public static void main(String[] args) {
        int query_len = 0;
        double distance = 0.0d;
        boolean is_log_title;
    }

    static boolean check(int query_len, double distance, boolean is_log_title){
        if(query_len >= 5){
            if(is_log_title && distance >= 0.9){
                return true;
            }else if(distance >= 0.95){
                return true;
            }
        }else if(query_len > 2 && query_len <= 5 && distance > 0.95){
            return true;
        }else if(query_len <= 2 && distance == 1){
            return true;
        }
        return false;
    }

    static boolean check1(int query_len, double distance, boolean is_log_title){
        if(query_len >= 5){
            if((is_log_title && distance >= 0.9) || distance >= 0.95){
                return true;
            }
        }else if(query_len <= 2 && distance == 1){
            return true;
        } else if(query_len > 2 && distance > 0.95) {
            return true;
        }
        return false;
    }

    static boolean checkSimplify(int query_len, double distance, boolean is_log_title){
        boolean condi1 = query_len >= 5 && ((is_log_title && distance >= 0.9) || distance >= 0.95);
        boolean condi2 = query_len > 2 && query_len <= 5 && distance > 0.95;
        boolean condi3 = query_len <= 2 && distance == 1;
        if(condi1 || condi2 || condi3){
            return true;
        }
        return false;
    }
}
