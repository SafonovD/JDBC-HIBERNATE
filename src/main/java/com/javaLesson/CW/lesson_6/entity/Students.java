package com.javaLesson.CW.lesson_6.entity;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@DynamicUpdate
@DynamicInsert

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "students_group_id")
    private StudentGroups studentGroups;


    public Students() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentGroups getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(StudentGroups studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public String toString() {
        return "Students{" +
                "Id = " + studentId +
                ", Имя = '" + name + '\'' +
                ", Фамилия = '" + lastName + '\'' +
                '}';
    }
}
