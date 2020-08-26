package com.learn.java.lang.wangs.spring.bean;

import org.springframework.stereotype.Component;

// 将蔡琴CD作为组建放入SpringBean中
@Component
public class CaiQinCD implements CompactDisc {

    private String singer = "CaiQin";

    @Override
    public void play() {
        System.out.println(this.singer + "演唱：" + "《你的眼神》。。。当一阵细雨洒落我心底。。。");
    }

}
