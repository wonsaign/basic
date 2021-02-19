package com.learn.java.lang.wangs.base.abstracted;

public interface Iter {

    void begin();

    void end();

    abstract class ImplT implements Iter{

        protected final String str;

        public ImplT(String a){
            this.str = a;
        }

        @Override
        public void begin() {
            str.toString();
        }

        @Override
        public void end() {
            str.length();
        }
    }
}
