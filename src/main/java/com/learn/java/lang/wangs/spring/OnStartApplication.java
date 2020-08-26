package com.learn.java.lang.wangs.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public abstract class OnStartApplication implements ApplicationListener<ContextStartedEvent> {


    @Override
    public final void onApplicationEvent(ContextStartedEvent event) {
        try {
            onStartLoad();
        } catch (Exception e) {
        }
    }

    public abstract void onStartLoad();
}
