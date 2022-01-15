package com.javaLesson.CW.lesson_6;

import com.javaLesson.CW.lesson_6.entity.Students;
import com.javaLesson.CW.lesson_6.entity.Teachers;
import com.javaLesson.CW.lesson_6.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TeacherUtil {
    private SessionFactory sessionFactory;

    public TeacherUtil() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Teachers> getTeachersAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teachers> cq = cb.createQuery(Teachers.class);

        Root<Teachers> root = cq.from(Teachers.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Teachers> teachersList = query.getResultList();
        session.close();
        return teachersList;
    }

    public  void deleteTeacherFromFilds(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Teachers> cd = cb.createCriteriaDelete(Teachers.class);
        Root<Teachers> root = cd.from(Teachers.class);

        cd.where(cb.like(root.get("phone"), "%61%"));
        Query query = session.createQuery(cd);
        int deleted = query.executeUpdate();
        System.out.println("Удалено: " + deleted);
        session.getTransaction().commit();

        session.close();
    }

    public void deleteTeacherById(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teachers teacher = session.get(Teachers.class, id);
        session.delete(teacher);

        session.getTransaction().commit();
        session.close();
    }

}
