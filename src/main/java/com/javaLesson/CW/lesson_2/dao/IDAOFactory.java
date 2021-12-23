package com.javaLesson.CW.lesson_2.dao;

/**
 * Created by Asus on 31.01.2018.
 */
public interface IDAOFactory {

    CarDAO getCarDAO();

    ClientDAO getClientDAO();


}
