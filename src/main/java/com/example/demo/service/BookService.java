package com.example.demo.service;

import java.util.List;

import com.example.demo.Book.Book;

public interface BookService {
   public List<Book> getAllBook();
   public boolean saveBook(Book book);
   public void deleteBook(Integer id);
   public Book getBookById(Integer id);
}
