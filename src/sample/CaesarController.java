package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CaesarController {

    @FXML private TextField keyField;
    @FXML private TextField messageField;
    @FXML private TextField encryptedMessageField;
    @FXML private TextArea decryptedMessageField;

    private Caesar caesar;

    @FXML
    private void initialize() {
        caesar = new Caesar("");
    }

    @FXML
    private void onGenerateKey() {
        String key = keyField.getText();
        caesar.setShift(key);
    }

    @FXML
    private void onEncrypt() {
        String message = messageField.getText();
        String cipherText = caesar.encrypt(message);
        encryptedMessageField.setText(cipherText);
    }

    @FXML
    private void onDecrypt() {
        String cipherText = encryptedMessageField.getText();
        String decipherText = caesar.decrypt(cipherText);
        decryptedMessageField.setText(decipherText);
    }
}
