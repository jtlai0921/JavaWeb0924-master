package com.mycompany.web.websocket.server;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/simple/ws/server")
public class SimpleServer {
    
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("建立連線 sessionID: " + session.getId());
        session.getAsyncRemote().sendText("建立連線 sessionID:" + session.getId());
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException, EncodeException {
        System.out.println("訊息: " + message + ", sessionID: " + session.getId());
        if (session.isOpen()) {
            session.getAsyncRemote().sendText("訊息: " + message + ", sessionID: " + session.getId());
        }
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉連線 sessionID: " + session.getId());
    }
    
    
}
