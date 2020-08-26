package com.learn.java.lang.wangs.pattern.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class StudyBoard extends Observable implements Subject {

    List<Observer> obs = new ArrayList<>();
    ;

    @Override
    public void registObs(Observer o) {
        obs.add(o);
    }

    @Override
    public void removetObs(Observer o) {
        obs.remove(o);
    }

    @Override
    public void nofifyObs() {
        for (Observer observer : obs) {
            observer.update();
        }
    }

}
