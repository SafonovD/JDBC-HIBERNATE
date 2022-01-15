package com.javaLesson.CW.lesson_6.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "student_groups", schema = "academy")
public class StudentGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int groupId;
    @Basic
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "studentGroups",fetch = FetchType.EAGER)
    private List<Students> studentsList = new ArrayList<>();

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }
    @Override
    public String toString() {
        return "StudentGroups{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
