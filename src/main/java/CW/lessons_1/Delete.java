package CW.lessons_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private static final String URL = "jdbc:mysql://localhost:3306/cofeehouse";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String DELETE_CLIENTS = "DELETE FROM clients where id = ?";

    public static void main(String[] args) {

        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = connection.prepareStatement(DELETE_CLIENTS);

            statement.setInt(1,10);

            statement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                statement.close();
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void registerDriver () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
