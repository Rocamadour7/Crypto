package sample;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;

public class DatabaseController {

    @FXML private JFXTextField newEmployeeNameField;
    @FXML private JFXTextField newEmployeePositionField;
    @FXML private JFXTextField selectedEmployeeName;
    @FXML private JFXTextField selectedEmployeePosition;


    @FXML
    private void initialize() {
        RequiredFieldValidator nameRequired = new RequiredFieldValidator();
        RequiredFieldValidator positionRequired = new RequiredFieldValidator();
        RequiredFieldValidator selectedEmployeeRequired = new RequiredFieldValidator();

        nameRequired.setMessage("Name required");
        positionRequired.setMessage("Position required");
        selectedEmployeeRequired.setMessage("Select a row from the table");

        newEmployeeNameField.getValidators().add(nameRequired);
        newEmployeePositionField.getValidators().add(positionRequired);
        selectedEmployeePosition.getValidators().add(selectedEmployeeRequired);
    }

    @FXML
    private void onCreate() {
        newEmployeeNameField.validate();
        newEmployeePositionField.validate();
    }

    @FXML
    private void onDecrypt() {
        selectedEmployeePosition.validate();
    }
}
