package com.javaLesson.CW.lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonUtill {

    private static final List<String> NAMES = List.of("Вася", "Петя", "Надежда", "Константин", "Макс", "Сергей",
            "Любовь", "Махаил", "Евгений", "Татьяна", "Наталья", "Максим",
            "Людмила", "Юлия", "Снежана", "Николай", "Риналь", "Тимур");


    int count = 0;

    private List<Person> person = new ArrayList<>();

    public List<Person> fillUpPerson(int n){

        while(count < n) {
            int randomIndex = new Random().nextInt(NAMES.size());
            person.add(new Person(NAMES.get(randomIndex), new Random().nextInt(100)));
            count++;
        }
        return person;
    }
}
