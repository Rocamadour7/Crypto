package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.mindrot.BCrypt;

public class BCryptController {

    @FXML private TextField messageField;
    @FXML private TextField encryptedMessageField;
    @FXML private TextField verificationMessageField;
    @FXML private Text verificationText;

    private String encryptedMessage;

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
