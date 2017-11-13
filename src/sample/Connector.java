package sample;

import java.sql.*;


public class Connector {

    private static Connection connection;

    private static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crypto","root","root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static ResultSet statement() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM staff");
        while(resultSet.next()){

            System.out.println(resultSet.getString(2)+" "+resultSet.getString(3));

        }
        //connection.close();
        return resultSet;
    }

    private static void insert(String name, String position) throws SQLException{
        System.out.println("Adding...");
        String query = " insert into staff (name, position)"
                + " values (?, ?)";

        // create the mysql insert prepared statement
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (1, name);
        preparedStmt.setString (2, position);

        // execute the prepared statement
        preparedStmt.execute();

        connection.close();
    }


    public static void main(String[] args) {
        connect();
        try {
            statement();
            insert("Tony", "Janitor");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
