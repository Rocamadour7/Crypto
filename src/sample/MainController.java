package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML private Button minimizeButton;
    @FXML private Button closeButton;
    @FXML private Button rsaButton;
    @FXML private Button bcryptButton;

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void minimizeWindow() {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void goToRSA() {
        Stage stage;
        Parent root;
        stage=(Stage) rsaButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("RSA.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToBCrypt() {
        Stage stage;
        Parent root;
        stage=(Stage) bcryptButton.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("BCrypt.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
