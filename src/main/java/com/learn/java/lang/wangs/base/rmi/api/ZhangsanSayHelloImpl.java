package com.learn.java.lang.wangs.base.rmi.api;

/**
 * All rights Reserved, Designed By www.drplant.com.cn
 *
 * @ProjectName: basic
 * @Package: com.learn.java.lang.wangs.base.rmi.api
 * @ClassName: ZhangsanSayHelloImpl
 * @Description: []
 * @Author: [wang sai]
 * @Date: 2021/10/18 3:18 下午
 * @Version: V1.0
 * @Copyright: 2019 www.drplant.com.cn Inc. All rights reserved.
 **/
public class ZhangsanSayHelloImpl implements SayHello{
    @Override
    public void sayHello() {
        System.out.println("this is zhangsan");
    }
}
