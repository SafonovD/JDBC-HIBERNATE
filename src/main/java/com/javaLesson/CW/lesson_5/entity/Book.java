package com.javaLesson.CW.lesson_5.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@ToString
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long author_id;

    @Column(name = "Theme")
    private String theme;

    public Book(){}

    public Book(String name, String theme) {
        this.name = name;
        this.theme = theme;
    }
}
