package com.learn.java.lang.wangs.rebuild;

abstract class Humans {
    final boolean isMate;

    //abstract boolean isMate();
    static Man createMan() {
        return new Man();
    }

    static Woman createWoman() {
        return new Woman();
    }

    // this method is core
    public Humans(boolean isMate) {
        this.isMate = isMate;
    }
}

class Man extends Humans {
    public Man() {
        super(false);
    }
//	@Override
//	// 常量函数
//	boolean isMate() {
//		return true;
//	}
}

class Woman extends Humans {
    public Woman() {
        super(true);
    }
//	@Override
//	// 常量函数
//	boolean isMate() {
//		return false;
//	}
}


public class ConstantMethod {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Humans h = Humans.createMan();

    }
}
