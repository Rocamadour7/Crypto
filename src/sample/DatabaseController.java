package sample;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

public class DatabaseController {

    @FXML private JFXTextField newEmployeeNameField;
    @FXML private JFXTextField newEmployeePositionField;
    @FXML private JFXTextField selectedEmployeeName;
    @FXML private JFXTextField selectedEmployeePosition;
    @FXML private JFXTreeTableView<Staff> staffTable;


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

        populateTable();
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

    private void populateTable() {
        JFXTreeTableColumn<Staff, Integer> idColumn = new JFXTreeTableColumn<>("ID");
        JFXTreeTableColumn<Staff, String> nameColumn = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<Staff, String> positionColumn = new JFXTreeTableColumn<>("Position");

        idColumn.setPrefWidth(50);
        nameColumn.setPrefWidth(180);
        positionColumn.setPrefWidth(180);

        idColumn.setCellValueFactory(param -> param.getValue().getValue().getId().asObject());
        nameColumn.setCellValueFactory(param -> param.getValue().getValue().getName());
        positionColumn.setCellValueFactory(param -> param.getValue().getValue().getPosition());

        ObservableList<Staff> staffList = FXCollections.observableArrayList();
        staffList.add(new Staff(1, "Luis", "CEO"));

        final TreeItem<Staff> root = new RecursiveTreeItem<>(staffList, RecursiveTreeObject::getChildren);
        staffTable.getColumns().setAll(idColumn, nameColumn, positionColumn);
        staffTable.setRoot(root);
        staffTable.setShowRoot(false);
    }
}
