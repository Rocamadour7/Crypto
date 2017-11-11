package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    public void show(String fxmlURL) {
//        Stage stage;
//        stage=(Stage) closeButton.getScene().getWindow();
//        try {
//            root = FXMLLoader.load(getClass().getResource(fxmlURL));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
}
