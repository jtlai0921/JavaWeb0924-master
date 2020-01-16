package com.mycompany.web.websocket;

import java.net.URI;
import java.util.Scanner;
import javax.websocket.ContainerProvider;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class SimpleClient {
public static void main(String[] args) throws Exception {
        URI uri = new URI("ws://localhost:8080/JavaWeb0924/websocket/server");
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(new SimpleClientSocketHandler(), uri);
        
        RemoteEndpoint.Async remote = session.getAsyncRemote();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("請輸入訊息: ");
            String msg = scanner.nextLine();
            if(msg.equalsIgnoreCase("exit")) {
                break;
            }
            remote.sendText(msg);
        }
        
        session.close();
        
    }
}
