package sample;

import javafx.fxml.FXML;

public class MainController {

    private TemplateController templateController;

    void injectTemplateController(TemplateController templateController) {
        this.templateController = templateController;
    }

    @FXML
    private void goToRSA() {
        templateController.show("RSA.fxml");
    }

    @FXML
    private void goToBCrypt() {
        templateController.show("BCrypt.fxml");
    }

    @FXML
    private void goToCaesar() {
        templateController.show("Caesar.fxml");
    }

    @FXML
    private void goToDatabase() {
        templateController.show("Database.fxml");
    }
}
