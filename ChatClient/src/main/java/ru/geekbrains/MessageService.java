package ru.geekbrains;

import java.awt.*;
import java.io.IOException;

public class MessageService {
    private static final String HOST = "localhost";
    private static final int PORT = 65500;
    private NetworkHelper networkHelper;
    private javafx.scene.control.TextArea chatArea;

//    public MessageService(TextArea chatArea) {
//    }

    public MessageService(javafx.scene.control.TextArea chatArea) {
        this.chatArea = chatArea;
        connectToServer();
    }

    private void connectToServer() {
        try {
            this.networkHelper = new NetworkHelper(HOST, PORT, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage (String msg) {
        networkHelper.writeMessage(msg);
    }

    public void receiveMessage(String msg) {
        chatArea.appendText(msg + System.lineSeparator());
    }
}
