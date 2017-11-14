package sample;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;

import java.sql.SQLException;

public class DatabaseController {

    @FXML private JFXTextField newEmployeeNameField;
    @FXML private JFXTextField newEmployeePositionField;
    @FXML private JFXTextField selectedEmployeeName;
    @FXML private JFXTextField selectedEmployeePosition;
    @FXML private JFXTreeTableView<Staff> staffTable;
    @FXML private Button decryptButton;

    private Caesar caesar;
    private Connector databaseConnector;

    @FXML
    private void initialize() {
        caesar = new Caesar("pipo");
        databaseConnector = new Connector();

        RequiredFieldValidator nameRequired = new RequiredFieldValidator();
        RequiredFieldValidator positionRequired = new RequiredFieldValidator();
        RequiredFieldValidator selectedEmployeeRequired = new RequiredFieldValidator();

        nameRequired.setMessage("Name required");
        positionRequired.setMessage("Position required");
        selectedEmployeeRequired.setMessage("Select a row from the table");

        newEmployeeNameField.getValidators().add(nameRequired);
        newEmployeePositionField.getValidators().add(positionRequired);
        selectedEmployeePosition.getValidators().add(selectedEmployeeRequired);

        populateTable();
    }

    @FXML
    private void onCreate() {
        boolean nameValid = newEmployeeNameField.validate();
        boolean positionValid = newEmployeePositionField.validate();

        if(nameValid && positionValid) {
            String newEmployeeName = newEmployeeNameField.getText();
            String newEmployeePosition = newEmployeePositionField.getText();

            newEmployeeName = caesar.encrypt(newEmployeeName);
            newEmployeePosition = caesar.encrypt(newEmployeePosition);

            try {
                databaseConnector.insert(newEmployeeName, newEmployeePosition);
                newEmployeeNameField.setText(null);
                newEmployeePositionField.setText(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            populateTable();
        }
    }

    @FXML
    private void onDecrypt() {
        boolean selectedValid = selectedEmployeePosition.validate();

        if(selectedValid) {
            String decipherName = caesar.decrypt(selectedEmployeeName.getText());
            String decipherPosition = caesar.decrypt(selectedEmployeePosition.getText());
            selectedEmployeeName.setText(decipherName);
            selectedEmployeePosition.setText(decipherPosition);
            decryptButton.setDisable(true);
        }
    }

    private void populateTable() {
        JFXTreeTableColumn<Staff, Integer> idColumn = new JFXTreeTableColumn<>("ID");
        JFXTreeTableColumn<Staff, String> nameColumn = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<Staff, String> positionColumn = new JFXTreeTableColumn<>("Position");

        idColumn.setPrefWidth(50);
        nameColumn.setPrefWidth(179);
        positionColumn.setPrefWidth(179);

        idColumn.setResizable(false);
        nameColumn.setResizable(false);
        positionColumn.setResizable(false);

        idColumn.setCellValueFactory(param -> param.getValue().getValue().getId().asObject());
        nameColumn.setCellValueFactory(param -> param.getValue().getValue().getName());
        positionColumn.setCellValueFactory(param -> param.getValue().getValue().getPosition());

        ObservableList<Staff> staffList = null;
        try {
            staffList = databaseConnector.fetch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        final TreeItem<Staff> root = new RecursiveTreeItem<>(staffList, RecursiveTreeObject::getChildren);
        staffTable.getColumns().setAll(idColumn, nameColumn, positionColumn);
        staffTable.setRoot(root);
        staffTable.setShowRoot(false);

        staffTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedEmployeeName.setText(newValue.getValue().getName().getValue());
            selectedEmployeePosition.setText(newValue.getValue().getPosition().getValue());
            decryptButton.setDisable(false);
        });
    }
}
