package ru.geekbrains;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(loadFxml("/Chat.fxml"),600,600);
        primaryStage.setTitle("Мой чат");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static Parent loadFxml(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApp.class.getResource(fxml));
        return fxmlLoader.load();
    }
}