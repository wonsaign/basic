package com.learn.java.lang.wangs.pattern.observable;

public class TestClient {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Subject s = new StudyBoard();
        Observer one = new ClassMateOne(s);
        Observer two = new ClassMateTwo(s);
        s.nofifyObs();
    }
}
