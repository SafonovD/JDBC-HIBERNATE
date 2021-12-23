package com.javaLesson.CW.lesson_2.dao;

import com.javaLesson.CW.lesson_2.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {

    @Override
    public void add(Client client) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into clients(name,age,phone)VALUES (?,?,?)");
            statement.setString(1,client.getName());
            statement.setInt(2,client.getAge());
            statement.setString(3,client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && statement != null) {

                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Connection connection = null;

        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM clients");
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                long id = rs.getLong(1);
                String name = rs.getString(2);
               int age = rs.getInt(3);
               String phone = rs.getString(4);
               Client client = new Client(id,name,age,phone);
               clients.add(client);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null && statement != null){
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return clients;
    }

    @Override
    public Client getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        connection = getConnection();
        try{
            statement = connection.prepareStatement(" SELECT name,age,phone from clients where id = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String name = rs.getString(1);
                int age = rs.getInt(2);
                String phone = rs.getString(3);
                Client client = new Client(id,name,age,phone);
                return client;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null && statement != null){
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void updatePhone(String phone, int clientId) {
        Connection connection = null;
        PreparedStatement statement = null;

        connection = getConnection();
        try{
            statement = connection.prepareStatement( "UPDATE clients SET phone = ? WHERE id = ?");

            statement.setString(1,phone);
            statement.setInt(2,clientId);

            int up = statement.executeUpdate();

            System.out.println("обновлено записей " + up);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null && statement != null){
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public void remove(String name) {
        Connection connection = null;
        PreparedStatement statement = null;

        connection = getConnection();

        try{
            statement = connection.prepareStatement("delete from clients where name = ?");

            statement.setString(1,name);
            int del = statement.executeUpdate();
            System.out.println("Удалено записей "+ del);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null && statement != null){
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
