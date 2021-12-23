package com.javaLesson.CW.lesson_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Ad {
    private static final String URL = "jdbc:mysql://localhost:3306/cofeehouse";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

   // private static final String INS_COFF = "INSERT INTO category(Name) "
   //        + " VALUES(?)";
    private static final String INS_PERSONAL = "INSERT INTO personnels(Position_id, Fullname, Phone, Email) "
            + " VALUES(?,?,?,?)";

    public static void main(String[] args) throws SQLException {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(/*INS_COFF*/INS_PERSONAL );

         //   statement.setString(1, "Кофе");

            statement.setInt(1,1);
            statement.setString(2,"Сергеев Сергей Сергеевич");
            statement.setInt(3,768768768);
            statement.setString(4,"test@mail.ru");

            statement.execute();

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
