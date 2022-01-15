package com.javaLesson.CW.lesson_6;


import com.javaLesson.CW.lesson_6.entity.Students;
import com.javaLesson.CW.lesson_6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class StudentGetAll {
    private SessionFactory sessionFactory;

    public StudentGetAll() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Students> getStudents() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Students> cq = cb.createQuery(Students.class);

        Root<Students> root = cq.from(Students.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Students> studentsList = query.getResultList();
        session.close();
        return studentsList;
    }



}
