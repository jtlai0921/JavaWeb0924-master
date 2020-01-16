package com.mycompany.web.websocket;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@javax.websocket.ClientEndpoint
public class SimpleClientSocketHandler {
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Client onMessage() : " + message);
    }
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client onOpen()");
    }
    
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("Client onClose()");
    }
    
    @OnError
    public void onError(Session session, Throwable ex) {
        System.out.println("Client onError()");
    }
}
