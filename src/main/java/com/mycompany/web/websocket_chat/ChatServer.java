package com.mycompany.web.websocket_chat;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/chatserver")
public class ChatServer {
    // 用來存放WebSocket已連接的Socket
    static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<Session>();
    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException, EncodeException {
        System.out.println("message = " + message);
        for (Session s : sessions) {    //對每個連接的Client傳送訊息
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(message);
            }
        }
    }
    @OnOpen
    public void onOpen(Session session) {
        //紀錄連接到sessions中
        if (sessions.isEmpty()) {
            System.out.println("新連線:" + session.getId());
        }
        sessions.add(session);
        System.out.println("目前連線:" + sessions.size());
    }
    @OnClose
    public void onClose(Session session) {
        //將連接從sessions中移除
        System.out.println("關閉連線:" + session.getId());
        JsonObject obj = Json.createObjectBuilder()
                .add("userName", "系統")
                .add("message", "離開了聊天室")
                .build();
        sessions.remove(session);
        System.out.println("目前連線:" + sessions.size());
        for (Session s : sessions) { // 對每個連接的Client傳送訊息
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(obj.toString());
            }
        }
    }
}

