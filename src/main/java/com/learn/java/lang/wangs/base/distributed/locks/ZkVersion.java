//package com.learn.java.lang.wangs.base.distributed.locks;
//
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.utils.CloseableUtils;
//
///**
// * All rights Reserved, Designed By www.drplant.com.cn
// *
// * @ProjectName: dc-service-crm
// * @Package: com.zeusas.cloud.dc.crm
// * @ClassName: ZkVersion
// * @Description: []
// * @Author: [wang sai]
// * @Date: 2021/9/28 11:03 上午
// * @Version: V1.0
// * @Copyright: 2019 www.drplant.com.cn Inc. All rights reserved.
// **/
//public class ZkVersion extends AbstractDistributedLockDemo{
//
//    // ZooKeeper 服务地址, 单机格式为:(127.0.0.1:2181), 集群格式为:(127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183)
//    protected String connectString;
//
//    @Override
//    public void start() {
//        // 设置 ZooKeeper 服务地址为本机的 2181 端口
//        connectString = "192.168.9.203:2181";
//        // 重试策略
//        // 初始休眠时间为 1000ms, 最大重试次数为 3
//        //retry = new ExponentialBackoffRetry(1000, 3);
//        // 创建一个客户端, 60000(ms)为 session 超时时间, 15000(ms)为链接超时时间
//        client = CuratorFrameworkFactory.newClient(connectString, 60000, 15000, retry);
//        client2 = CuratorFrameworkFactory.newClient(connectString, 60000, 15000, retry);
//        // 创建会话
//        client.start();
//        client2.start();
//    }
//
//    @Override
//    public void end() {
//        CloseableUtils.closeQuietly(client);
//        CloseableUtils.closeQuietly(client2);
//    }
//}
