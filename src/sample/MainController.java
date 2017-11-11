package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML private Button minimizeButton;
    @FXML private Button closeButton;
    @FXML private Button rsaButton;
    @FXML private Button bcryptButton;

    TemplateController templateController;

    @FXML
    private void initialize() throws IOException {
    }

    public void injectTemplateController(TemplateController templateController) {
        this.templateController = templateController;
    }

    @FXML
    private void goToRSA() {
//        Stage stage;
//        Parent root;
//        stage=(Stage) rsaButton.getScene().getWindow();
//        try {
//            root = FXMLLoader.load(getClass().getResource("RSA.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        templateController.show("RSA.fxml");
    }

    @FXML
    private void goToBCrypt() {
        templateController.show("BCrypt.fxml");
    }
}
