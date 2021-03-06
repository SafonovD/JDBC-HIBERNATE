package com.javaLesson.CW.lesson_5;


import com.javaLesson.CW.lesson_5.entity.Book;
import com.javaLesson.CW.lesson_5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;


public class BookFill {
    private SessionFactory sessionFactory;

    public BookFill() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getAllBookList() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);

        cq.select(root);

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();
        session.close();

        return bookList;
    }

    public List<Book> getBookList() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);

        Selection[] selections1 = {root.get("name"), root.get("theme")};

        cq.select(cb.construct(Book.class, selections1));

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();
        session.close();

        return bookList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public Book addBook(Book book) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book updateBook(Book book) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Book newBook = session.get(Book.class, book.getId());
        newBook.setName(book.getName());
        newBook.setTheme(book.getTheme());
        session.save(newBook);

        session.getTransaction().commit();

        session.close();
        return book;
    }


}
