package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.mindrot.BCrypt;

public class BCryptController {

    @FXML private Button minimizeButton;
    @FXML private Button closeButton;
    @FXML private TextField messageField;
    @FXML private TextField encryptedMessageField;
    @FXML private TextField verificationMessageField;
    @FXML private Text verificationText;

    private String encryptedMessage;

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
    private void onEncrypt() {
        String message = messageField.getText();
        encryptedMessage = BCrypt.hashpw(message, BCrypt.gensalt());
        encryptedMessage = BCrypt.hashpw(message, BCrypt.gensalt(12));
        encryptedMessageField.setText(encryptedMessage);
    }

    @FXML
    private void onVerify() {
        String verifyText = verificationMessageField.getText();
        boolean isEqual = BCrypt.checkpw(verifyText, encryptedMessage);
        if (isEqual)
            verificationText.setText("It matches");
        else
            verificationText.setText("It does not match");

    }
}
