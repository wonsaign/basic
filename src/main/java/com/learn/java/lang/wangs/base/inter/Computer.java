package com.learn.java.lang.wangs.base.inter;

public class Computer implements IUsb1, IUsb2{

    @Override
    public void connect() {
        System.err.println("那我这个电脑的usb到底实现的是?");
    }
    
    
    public static void main(String[] args) {
        Computer c = new Computer();
        
        c.testU1(c);
        
        c.testU2(c);
    }
    
    public void testU1(IUsb1 iu) {
        iu.connect();
    }
    public void testU2(IUsb2 iu2) {
        iu2.connect();
    }

}
