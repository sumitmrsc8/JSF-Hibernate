/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sempra.dao;

import com.sempra.hiberutil.HibernateUtil;
import com.sempra.model.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sumit
 */
public class BookDaoImpl implements BookDao{

    public void save(Book book) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(book);
        tx.commit();
    }

    public Book getBook(int id) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        return (Book)session.load(Book.class, id);
    }

    public List<Book> list() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        List list=session.createQuery("from Book").list();
        t.commit();
        return list;
    }

    public void remove(Book book) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.delete(book);
        t.commit();
    }

    public void update(Book book) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.update(book);
        t.commit();
    }
    
}
