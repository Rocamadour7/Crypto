package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TemplateController {

    @FXML private Button minimizeButton;
    @FXML private Button closeButton;
    @FXML private Parent root;

    @FXML private MainController mainController;
    @FXML private Pane content;

    @FXML
    private void initialize() {
        mainController.injectTemplateController(this);
    }

    @FXML
    void show(String fxmlURL) {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource(fxmlURL)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void minimizeWindow() {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void backToHome() {
        try {
            root = FXMLLoader.load(getClass().getResource("template.fxml"));
            Stage primaryStage = (Stage) minimizeButton.getScene().getWindow();
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
