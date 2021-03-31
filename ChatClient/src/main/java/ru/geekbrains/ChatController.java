package ru.geekbrains;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    public TextArea chatArea;
    @FXML
    public ListView onlineUsers;
    @FXML
    public TextField input;
    @FXML
    public Button btnSendMassage;

    private ChatMessageService messageService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageService = new ChatMessageService("locslhost", 65500, (MessageProcessor) this);
        onlineUsers.setItems(FXCollections.observableArrayList("Фёдор", "Гриша", "Мыкола"));
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void shoeHelp(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://play.tavr.media/kissfm/deep/"));
    }

    public void mockAction(ActionEvent actionEvent) {
    }

    public void pressEnter(ActionEvent actionEvent) {
        appendTextFromTF();
    }

    public void btnSend(ActionEvent actionEvent) {
        appendTextFromTF();
    }

    private void appendTextFromTF() {
        String msg = input.getText();
        if (msg.length() > 0) {
            messageService.sendMessage(msg);
//            chatArea.appendText(msg + System.lineSeparator());
            input.clear();
        }
    }
}