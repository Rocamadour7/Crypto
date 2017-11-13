package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Staff extends RecursiveTreeObject<Staff> {

    private int id;
    private String name;
    private String position;

    public Staff(int id, String name, String position) {
        setId(id);
        setName(name);
        setPosition(position);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
