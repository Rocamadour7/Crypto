package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


class Connector {

    private static Connection connection;

    Connector() {
        connect();
    }

    private void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crypto","root","root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ObservableList<Staff> fetch() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM staff");

        ObservableList<Staff> staffList= FXCollections.observableArrayList();

        while(resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(1));
            String name =  resultSet.getString(2);
            String position = resultSet.getString(3);

            Staff staff = new Staff(id, name, position);
            staffList.add(staff);

        }
        return staffList;
    }

    void insert(String name, String position) throws SQLException{
        String query = "INSERT INTO staff (name, position)"
                + " VALUES (?, ?)";

        // create the mysql insert prepared statement
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (1, name);
        preparedStmt.setString (2, position);

        // execute the prepared statement
        preparedStmt.execute();
    }

}
