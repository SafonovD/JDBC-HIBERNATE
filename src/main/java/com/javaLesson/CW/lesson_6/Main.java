package com.javaLesson.CW.lesson_6;

import com.javaLesson.CW.lesson_6.entity.StudentGroups;
import com.javaLesson.CW.lesson_6.entity.Students;
import com.javaLesson.CW.lesson_6.entity.Teachers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

     StudentGetAll sga = new StudentGetAll();
     StudentGroupsUtil sgu = new StudentGroupsUtil();
     TeacherUtil tu = new TeacherUtil();

        System.out.println( "--------Студенты-------");
       List<Students> students = sga.getStudents();
//        for (Students students1 : students){
//            System.out.println( students1.getName() + " " + students1.getLastName());
//        }
        Map<StudentGroups, List<Students>> studentGroupsListMap = students.stream().collect(Collectors.groupingBy(Students::getStudentGroups));

        studentGroupsListMap.forEach(((studentGroups, students1) -> {
            System.out.println(studentGroups.getGroupName());
            students1.forEach(System.out::println);
            System.out.println();
        }));

        System.out.println("-----Список групп-------");
        List<StudentGroups> studentGroupsList = sgu.getStudentGroups();
        for (StudentGroups studentGroups : studentGroupsList){
            System.out.println(studentGroups.getGroupId() +  " " + studentGroups.getGroupName());
        }

        System.out.println();
        System.out.println("------Учителя----------");

        List<Teachers> teachers = tu.getTeachersAll();
        teachers.stream().forEach(System.out::println);

        tu.deleteTeacherFromFilds();
        tu.deleteTeacherById(1);




    }
}
