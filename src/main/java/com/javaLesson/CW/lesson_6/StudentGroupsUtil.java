package com.javaLesson.CW.lesson_6;


import com.javaLesson.CW.lesson_6.entity.StudentGroups;
import com.javaLesson.CW.lesson_6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentGroupsUtil {
    private SessionFactory sessionFactory;

    public StudentGroupsUtil() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public StudentGroups addStudentGroups(StudentGroups studentGroups) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(studentGroups);
        session.getTransaction().commit();
        session.close();
        return studentGroups;
    }

    public StudentGroups updatstudentGroups(StudentGroups studentGroups) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        StudentGroups newstudentGroups = session.get(StudentGroups.class, studentGroups.getGroupId());
        newstudentGroups.setGroupName(studentGroups.getGroupName());
        session.save(newstudentGroups);

        session.getTransaction().commit();
        session.close();
        return studentGroups;
    }

    public List<StudentGroups> getStudentGroups() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(StudentGroups.class);
        Root<StudentGroups> root = criteriaQuery.from(StudentGroups.class);

        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);

        List<StudentGroups> studentGroupsList = query.getResultList();

        session.close();
        return studentGroupsList;
    }

    public StudentGroups getStudentsGroupById(int id) {
        Session session = sessionFactory.openSession();
        StudentGroups studentGroups = session.get(StudentGroups.class, id);
        session.close();
        return studentGroups;
    }
}
