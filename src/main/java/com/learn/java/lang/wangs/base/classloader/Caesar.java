package com.learn.java.lang.wangs.base.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Caesar {

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Use three test");
            return;
        }
        
        try(FileInputStream in = new FileInputStream(args[0])){
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
