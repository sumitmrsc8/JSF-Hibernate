/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sempra.controller;
import com.sempra.dao.BookDao;
import com.sempra.model.Book;
import com.sempra.dao.BookDaoImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


/**
 *
 * @author Sumit
 */
@ManagedBean
@SessionScoped
public class BookController {
    private Book book;
    private DataModel dataModel;
    
    
    public DataModel getListOfBooks(){
        List<Book> bookList=new BookDaoImpl().list();
        dataModel=new ListDataModel(bookList);
        return dataModel;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public String prepareAddOnBook(){
        book=new Book();
        return "result";
    }
    
    public String prepareChangeBook(){
        book=(Book)(dataModel.getRowData());
        return "result";
    }
    
    public String deleteBook(){
        Book bookTemp=(Book)(dataModel.getRowData());
        BookDao bookDao=new BookDaoImpl();
        bookDao.remove(book);
        return "index";
    }
    
    public String addBook(){
        BookDao bookDao=new BookDaoImpl();
        bookDao.save(book);
        return "index";
    }
    
    public String editBook(){
        BookDao bookDao=new BookDaoImpl();
        bookDao.update(book);
        return "index";
    }
}
