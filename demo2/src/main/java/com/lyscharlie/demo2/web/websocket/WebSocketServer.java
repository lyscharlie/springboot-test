package com.lyscharlie.demo2.web.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lyscharlie.demo2.common.dto.SocketMessageDTO;

import lombok.extern.slf4j.Slf4j;

@ServerEndpoint("/webSocket/{sid}")
@Component
@Slf4j
public class WebSocketServer {

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private final static AtomicInteger onlineNum = new AtomicInteger();

	// concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
	private final static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

	/**
	 * 发送消息
	 *
	 * @param session
	 * @param message
	 */
	public void sendMessage(Session session, String message) {
		if (session != null) {
			synchronized (session) {
				try {
					log.info("发送数据：{}", message);
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					log.error("发送数据失败", e);
				}
			}
		}
	}

	/**
	 * 建立连接成功调用
	 *
	 * @param session
	 * @param userName
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "sid") String userName) {
		sessionPools.put(userName, session);
		addOnlineCount();

		log.info("{}加入webSocket！当前人数为P{}", userName, onlineNum);

		sendMessage(session, "欢迎" + userName + "加入连接！");
	}

	/**
	 * 关闭连接时调用
	 *
	 * @param userName
	 */
	@OnClose
	public void onClose(@PathParam(value = "sid") String userName) {
		sessionPools.remove(userName);
		subOnlineCount();
		log.info("{}断开webSocket连接！当前人数为{}", userName, onlineNum);
	}

	/**
	 * 收到客户端信息
	 *
	 * @param message
	 */
	@OnMessage
	public void onMessage(String message) {
		SocketMessageDTO msg = JSON.parseObject(message, SocketMessageDTO.class);

		Session session = sessionPools.get(msg.getTo());
		sendMessage(session, msg.getContent());
	}

	/**
	 * 错误时调用
	 *
	 * @param session
	 * @param throwable
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {
		log.info("发生错误");
		throwable.printStackTrace();
	}

	public static void addOnlineCount() {
		onlineNum.incrementAndGet();
	}

	public static void subOnlineCount() {
		onlineNum.decrementAndGet();
	}
}
