package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(65501)) {
            System.out.println("System started");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread write = new Thread(() -> {
                while (true) {
                    try {
                        String msg = scanner.nextLine();
                        out.writeUTF("Server send: " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            write.setDaemon(true);
            write.start();
            while (true) {
                try {
                    String massage = in.readUTF();
                    System.out.println(massage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
