package com.sap.WebSocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String received = message.getPayload();
        System.out.println("Received: @ Server " + received);

        // Echo back the message with a prefix
        session.sendMessage(new TextMessage("Server Response:Hey Msg From Server " + received+" Reciprocated ..."));
       String newMsg ="Hi, Welcome to Socket Programming";
        session.sendMessage(new TextMessage("Server Response:Hey Msg From Server " + newMsg));
    }
}

