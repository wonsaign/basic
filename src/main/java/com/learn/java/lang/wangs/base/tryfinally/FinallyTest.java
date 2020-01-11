package com.learn.java.lang.wangs.base.tryfinally;

public class FinallyTest {

    public static void main(String[] args) {
        
        int testFinally = testFinally();
        
        System.err.println(testFinally);
    }
    
    /**
     * 正如我所料
     * @return
     * @author wangsai
     * @date 2020年1月2日 上午10:44:24
     */
    /**
     * return 值是有一个ref来接受的, 在try finally 块儿区间, try 块儿先给return的ref赋值1,
     * 但是因为finally一定会在try之后执行,所以return的ref的值会被覆盖为-1
     * 所以最终返回-1
     * 
     */
    @SuppressWarnings("finally")
    public static int testFinally() {
        try {
            return 1;
        } finally {
            return -1;
        }
        
    }
    
}


