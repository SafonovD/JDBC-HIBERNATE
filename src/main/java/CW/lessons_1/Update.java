package CW.lessons_1;

import java.sql.*;

public class Update {
    private static final String URL = "jdbc:mysql://localhost:3306/cofeehouse";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    // private static final String UPDATE_PRICE = "UPDATE menu SET Price = ? where Id = ?";
    private static final String UPDATE_PHONE = "UPDATE menu set Price = ? where id = ?";

    public static void main(String[] args) {

        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = connection.prepareStatement(/*UPDATE_NEW*/ UPDATE_PHONE);


         //   statement.setInt(4,180);
         //   statement.setInt(1,9);

           statement.setInt(2,256);
           statement.setInt(1,9);


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
