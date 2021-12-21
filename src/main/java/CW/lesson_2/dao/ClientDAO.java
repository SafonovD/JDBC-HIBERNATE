package CW.lesson_2.dao;

import CW.lesson_2.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    void add(Client client);
    List<Client> getAll();
    Client getById(int id);
    void updatePhone(String phone, int clientId);
    void remove(String name);
}
