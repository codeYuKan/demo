package com.yukan.demo.websocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Chat Server
 *
 * @author yukan
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/chat/{client}")
public class WebSocketChatServer {

    /**
     * static value, count of online users
     */
    private static int onlineCount = 0;

    private static Map<String, WebSocketChatServer> clients = new ConcurrentHashMap<>();

    /**
     * websocket connection session
     * for send message
     */
    private Session session;

    private String client;

    /**
     * success build connection
     */
    @OnOpen
    public void onOpen(@PathParam("client") String client, Session session) {
        log.info("WebSocketServer.open:session:{},client:{}", session, client);
        this.session = session;
        this.client = client;
        //加入set中
        clients.put(client, this);
        //在线数加1
        addOnlineCount();
        log.info("new connection join！current online client count:{}", getOnlineCount());
        try {
            sendMessage("连接成功");
            sendMessageTo("dcp", client);
        } catch (IOException e) {
            log.error("websocket IO异常");
        }

    }

    /**
     * connection close
     */
    @OnClose
    public void onClose() {
        //从set中删除
        clients.remove(client);
        //在线数减1
        subOnlineCount();
        log.info("connection close！current online client count:{}", getOnlineCount());
    }

    /**
     * receive client message
     *
     * @param message client message
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("receive client message:{}" + message);
    }

    /**
     * connection error
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("connection error:", error);
    }

    /**
     * 消息发送
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        //阻塞式的
        this.session.getBasicRemote().sendText(message);
        //非阻塞式的
//        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 消息发送外部调用
     *
     * @param message
     * @param to
     * @throws IOException
     */
    public static void sendMessageTo(String message, String to){
        try {
            log.info("message={}", message);
            clients.get(to).sendMessage(message);
        } catch (IOException e) {
            log.error("发送失败:", e);
        }
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message){
        log.info(message);
        for (WebSocketChatServer item : clients.values()) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                log.error("发送失败:", e);
            }
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketChatServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketChatServer.onlineCount--;
    }
}
