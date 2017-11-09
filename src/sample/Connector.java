package sample;

import java.sql.*;

public class Connector {

    public static Connection connection;

    public static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crypto","root","root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void statement() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM staff");
        while(resultSet.next()){

            System.out.println(resultSet.getString(2)+" "+resultSet.getString(3));

        }
        connection.close();
    }

    //Funcion para insertar datos a la base de datos
    //Funcion que mande a llamar la de encriptacion
    //diseño singleton
    //Esa funcion tiene que llmar a esa funcion para validarlos

    public static void main(String[] args) {
        connect();
        try {
            statement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
