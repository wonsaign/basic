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
// * @ClassName: CuratorTestVersion
// * @Description: []
// * @Author: [wang sai]
// * @Date: 2021/9/28 11:05 上午
// * @Version: V1.0
// * @Copyright: 2019 www.drplant.com.cn Inc. All rights reserved.
// **/
//public class CuratorTestVersion extends AbstractDistributedLockDemo{
//
//    private TestingServer singleServer;
//
//    private TestingCluster clusterServer;
//
//    @Override
//    public void start() {
//        cluster();
//    }
//
//    private void single(){
//        // 单节点启动
//        try {
//            singleServer = new TestingServer();
//            singleServer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // server.getConnectString() 方法会返回可用的服务链接地址, 如: 127.0.0.1:2181
//        client = CuratorFrameworkFactory.newClient(singleServer.getConnectString(), retry);
//        client2 = CuratorFrameworkFactory.newClient(singleServer.getConnectString(), retry);
//        client.start();
//        client2.start();
//    }
//
//    private void cluster(){
//        // 集群启动
//        //QuorumPeerMain.main(null);
//        clusterServer = new TestingCluster(3);
//        try {
//            clusterServer.start();
//            Thread.sleep(2000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (TestingZooKeeperServer zs : clusterServer.getServers()) {
//            System.out.print(zs.getInstanceSpec().getServerId() + "-");
//            System.out.print(zs.getQuorumPeer().getServerState() + "-");
//            System.out.println(zs.getInstanceSpec().getDataDirectory().getAbsolutePath());
//        }
//        // server.getConnectString() 方法会返回可用的服务链接地址, 如: 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
//        client = CuratorFrameworkFactory.newClient(clusterServer.getConnectString(), retry);
//        client2 = CuratorFrameworkFactory.newClient(clusterServer.getConnectString(), retry);
//        client.start();
//        client2.start();
//    }
//
//    private void closeSingle(){
//        CloseableUtils.closeQuietly(client);
//        CloseableUtils.closeQuietly(client2);
//        CloseableUtils.closeQuietly(singleServer);
//    }
//    private void closeCluster(){
//        CloseableUtils.closeQuietly(client);
//        CloseableUtils.closeQuietly(client2);
//        CloseableUtils.closeQuietly(clusterServer);
//    }
//
//
//    @Override
//    public void end() {
//        closeCluster();
//    }
//}
