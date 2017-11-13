package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Staff extends RecursiveTreeObject<Staff> {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty position;

    Staff(int id, String name, String position) {
        setId(id);
        setName(name);
        setPosition(position);
    }

    IntegerProperty getId() {
        return id;
    }

    private void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    StringProperty getName() {
        return name;
    }

    private void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    StringProperty getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = new SimpleStringProperty(position);
    }
}
