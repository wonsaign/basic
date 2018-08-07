package com.learn.java.lang.wangs.util.websocket;


import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.learn.java.lang.wangs.util.QString;

@ComponentScan
@Component
public class SocketServer extends WebSocketServer {
	
	public SocketServer() throws UnknownHostException {
        super();
    }
	
    public SocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // WS协议连接的时候触发的代码，onOpen中不做任何操作
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //断开连接时候触发代码
        userLeave(conn);
        System.out.println(reason);
    }

    // {"NetUserCode": "",	"CompanyCode": "",	"Desc": ""}
    @Override
    public void onMessage(WebSocket conn, String message) {
        Map<String,Object> params = JSON.parseObject(message);
        // 联网单位与分公司的联系，是传递过来的
        // 联网单位 连接
        if(!QString.isNullOrEmpty(params.get("NetUserCode"))){
        	List<WebSocket> wss = SocketPool.getWsByCode(params.get("NetUserCode").toString());
        	if(wss.isEmpty()){
        		userJoin(conn,params.get("NetUserCode").toString());//用户加入
        	}
        }
        // 分公司 链接
        if(!QString.isNullOrEmpty(params.get("CompanyCode"))) {//
        	userJoin(conn,params.get("CompanyCode").toString());
        }
        // 联网单位发送
		for (WebSocket webSocket : SocketPool.getWsByCode(params.get("NetUserCode").toString())) {
			if(!QString.isNullOrEmpty(params.get("Desc"))){
				SocketPool.sendMessageToUser(webSocket,params.get("Desc").toString());
			}
		}
		// 分公司发送
		for (WebSocket webSocket : SocketPool.getWsByCode(params.get("CompanyCode").toString())) {
			if(!QString.isNullOrEmpty(params.get("Desc"))){
				SocketPool.sendMessageToUser(webSocket,params.get("Desc").toString());
			}
		}
    }
    

    @Override
    public void onError(WebSocket conn, Exception ex) {
        //错误时候触发的代码
        System.out.println("on error");
        ex.printStackTrace();
    }
    private void userLeave(WebSocket conn){
        SocketPool.removeUser(conn);
    }
    private void userJoin(WebSocket conn,String userName){
        SocketPool.addUser(userName, conn);
    }
	static {
		WebSocketImpl.DEBUG = false;
		int port = 8887; // 端口
		SocketServer client = null;
		client = new SocketServer(port);
		client.start();
		System.out.println("WebSocketClient 已启动");  
	}
    
//	public static void main(String args[]){
//		WebSocketImpl.DEBUG = false;
//		int port = 8887; // 端口
////		InetSocketAddress ita = new InetSocketAddress("127.0.0.1",port);
//	  //  	WsServer client = new WsServer(port);
//		SocketServer client = null;
//		client = new SocketServer(port);
//		client.start();
//		System.out.println("WebSocketClient 已启动");  
//		System.out.println("Staring");
//	}
//	NetUnitInfoService netUnitInfoService = AppContext.getBean(NetUnitInfoService.class);
//	Map<String,String> map = new HashMap<>();
//	map.put("companyCode", params.get("CompanyCode").toString());
//	PageBean<NetUnitInfo> net = netUnitInfoService.listNetByCompanyCode(map);
//	List<NetUnitInfo> netInfos = net.getLists();
	// 将当前的联网单位加入到所有已经连接入
//	for (NetUnitInfo netUnitInfo : netInfos) {
//		if(WsPool.getWsByCode(netUnitInfo.getUnitCode()).isEmpty()){
//			userJoin(conn,netUnitInfo.getUnitCode());
//			continue;
//		}
//	}
    
}