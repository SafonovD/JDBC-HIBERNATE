package CW.lesson_2;

import CW.lesson_2.dao.CarDAO;
import CW.lesson_2.dao.ClientDAO;
import CW.lesson_2.dao.DAOFactory;
import CW.lesson_2.dao.IDAOFactory;
import CW.lesson_2.entity.Car;
import CW.lesson_2.entity.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();

// ============== add(Clients) ============
        Client client1 = new Client();
        client1.setName("Петя");
        client1.setAge(16);
        client1.setPhone("+67577657");
        clientDAO.add(client1);

// ============== add(Car car) ============

//        Car car1 = new Car();
//        car1.setMark("Audi");
//        car1.setModel("A8");
//        car1.setPrice(15_000);
//
//        carDAO.add(car1);


//        Car car2 = new Car();
//        car2.setMark("Chevrolet");
//        car2.setModel("E2");
//        car2.setPrice(45_000);
//
//        carDAO.add(car2);


           // =========== getAll(Cliens) ============

        List<Client> clients = clientDAO.getAll();
        for (Client cl: clients ) {
            System.out.println(cl);

        }

// =========== getAll() ============

//        List<Car> cars = carDAO.getAll();
//        for (Car car : cars) {
//            System.out.println(car);
//        }
//

        // =========== getById(int id Clients)  ============

        Client client2 = clientDAO.getById(2);
        System.out.println(client2);

// =========== getById(int id)  ============

//        Car car3 = carDAO.getById(2);
//        System.out.println(car3);


// ===========  updatePhone(String phone, int clientId) ============
        clientDAO.updatePhone("+235453",1);

// ===========  updatePrice(int price, int carId) ============
//        carDAO.updatePrice(100_000, 1);

// ===========  remove(String name) ============

        clientDAO.remove("Петя");

// ===========  remove(String mark) ============
//        carDAO.remove("chevrolet");

    }

}
