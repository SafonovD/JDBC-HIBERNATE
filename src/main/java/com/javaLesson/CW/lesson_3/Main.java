package com.javaLesson.CW.lesson_3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.Scanner;


public class Main {

    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        PersonUtill person = new PersonUtill();
        System.out.println("введи количесво людей ");
        int value = sc.nextInt();
        List<Person> personList = person.fillUpPerson(value);

        addPerson(personList);

    }
    public static void addPerson(List<Person> person) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
            for (Person per : person) {
                session.save(per);
            }
        transaction.commit();
        session.close();
    }
}
