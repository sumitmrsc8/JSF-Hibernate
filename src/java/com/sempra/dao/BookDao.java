/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sempra.dao;
import com.sempra.model.Book;
import java.util.List;

/**
 *
 * @author Sumit
 */
public interface BookDao {
    public void save(Book book);
    public Book getBook(int id);
    public List<Book> list();
    public void remove(Book book);
    public void update(Book book);
    
}
