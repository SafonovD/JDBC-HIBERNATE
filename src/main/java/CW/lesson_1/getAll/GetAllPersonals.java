package CW.lesson_1.getAll;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllPersonals {

    private static final String URL = "jdbc:mysql://localhost:3306/cofeehouse";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String SELECT_ALL = "SELECT * FROM personnels";

    public void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Personnals> getAllPersonals() {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Personnals> personnal = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(SELECT_ALL);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int Position_id = resultSet.getInt("Position_id");
                String FullName = resultSet.getString("FullName");
                int Phone = resultSet.getInt("Phone");
                String Email = resultSet.getString("Email");

                Personnals personnals = new Personnals(id, Position_id, FullName, Phone, Email);
                personnal.add(personnals);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personnal;
    }
}



