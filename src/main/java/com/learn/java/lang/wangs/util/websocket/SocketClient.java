package com.learn.java.lang.wangs.util.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

public class SocketClient extends WebSocketClient{
	
//	final static Logger logger  = LoggerFactory.getLogger(SocketClient.class);

	public SocketClient(URI serverURI) {
		super(serverURI);
	}
	public SocketClient(URI serverUri, Draft draft) {
		super(serverUri, draft);
	}	
	public SocketClient(URI serverUri, Draft draft, Map<String, String> headers, int connecttimeout) {
		super(serverUri, draft, headers, connecttimeout);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		System.out.println("onOpen");
	}

	@Override
	public void onMessage(String message) {
		System.out.println("onMessage");
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("onClose");
	}

	@Override
	public void onError(Exception ex) {
		System.out.println("e");
		ex.printStackTrace();
	}
	
	public static void sendMessage(String message) throws URISyntaxException{
		SocketClient client = null;
		try{
			client = new SocketClient(new URI("ws://localhost:8887/"),new Draft_17());
			client.connect();
			while(!client.getReadyState().equals(READYSTATE.OPEN)){
				System.out.println("还没有打开");
			}
			System.out.println("打开了");
			client.send(message);
		}catch(Exception e){
//			logger.error("发送消息异常");
			e.printStackTrace();
		}finally {
			client.close();
		}
	    
	}
	
	public static void main(String[] args) throws URISyntaxException {
	    String s = "{\"NetUserCode\": \"JDABBJZNJSYXGS9467\",\"CompanyCode\": \"DDGJJ0396550137053\",\"Desc\": \"联网单位JDABBJZNJSYXGS9467测试\"}";
		sendMessage(s);
	}

}
