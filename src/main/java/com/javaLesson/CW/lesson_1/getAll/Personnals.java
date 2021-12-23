package com.javaLesson.CW.lesson_1.getAll;

public class Personnals {
    private int id;
    private int Position_id;
    private String FullName;
    private int Phone;
    private String Email;

    public Personnals(int id, int position_id, String fullName, int phone, String email) {
        this.id = id;
        Position_id = position_id;
        FullName = fullName;
        Phone = phone;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public int getPosition_id() {
        return Position_id;
    }

    public String getFullName() {
        return FullName;
    }

    public int getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "Официанты {" +
                "Полное имя = '" + FullName + '\'' +
                ", Телефон = " + Phone +
                ", Email ='" + Email + '\'' +
                '}';
    }
}
