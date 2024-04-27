package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Book.Book;
import com.example.demo.Book.BookRepository;
@Service
public class BookServiceImpl implements BookService {
    
	@Autowired
	private BookRepository repo;
	@Override
	public List<Book> getAllBook() {
		
		return repo.findAll();
	}
	@Override
	public boolean saveBook(Book book) {
		Book savebook=repo.save(book);
		//return savebook.getId()!=null;
		if(savebook.getId() != 0) {
			return true;
		}
		return false;
	}
	@Override
	public void deleteBook(Integer id) {
		repo.deleteById(id);
		
	}
	@Override
	public Book getBookById(Integer id) {
		Optional<Book> findById=repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
		
	}

}
