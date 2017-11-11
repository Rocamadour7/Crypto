package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ResourceBundle;

public class RSAController implements Initializable {

    private RSA rsa;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private StringBuffer[] hexKeys;
    private String cipherMessage;

    @FXML private TextField publicKeyField;
    @FXML private TextField privateKeyField;
    @FXML private TextField messageField;
    @FXML private TextField encryptedMessageField;
    @FXML private TextArea decryptedMessageField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rsa = RSA.getInstance();
    }

    @FXML
    private void generateKeys() {
        try {
            KeyPair keyPair = rsa.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
            hexKeys = rsa.hexString(keyPair);
            publicKeyField.setText(hexKeys[0].toString());
            privateKeyField.setText(hexKeys[1].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onEncrypt() {
        String message = messageField.getText();
        try {
            cipherMessage = rsa.encrypt(message, publicKey);
            encryptedMessageField.setText(cipherMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onDecrypt() {
        try {
            String decipherMessage = rsa.decrypt(cipherMessage, privateKey);
            decryptedMessageField.setText(decipherMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
