package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 65501)) {
            System.out.println("Connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread write = new Thread(() -> {
                while (true) {
                    try {
                    String msg = scanner.nextLine();
                        out.writeUTF("Client send: " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            write.start();
            write.setDaemon(true);
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
