package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Book.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {
     @Autowired
	private BookService service;
     @GetMapping("/books")
     public ModelAndView getBookDetails() {
    	List<Book> listbook= service.getAllBook();
    	 ModelAndView mv=new ModelAndView();
    	 mv.addObject("books", listbook);
    	 mv.setViewName("bookView");
    	 return mv;
     }
     @GetMapping("/index")
     public ModelAndView getSave() {
    	 ModelAndView mv=new ModelAndView();
    	 mv.addObject("book", new Book());
    	 mv.setViewName("index");
    	 return mv;
     }
     @PostMapping("/book")
     public ModelAndView Booksave(Book book) {
    	 ModelAndView mv=new ModelAndView();
    	boolean status=service.saveBook(book);
    	if(status) {
    		mv.addObject("succmsg", "Book Save");
    	}else {
    		mv.addObject("errmsg", "not saved");
    		   	}
    	 mv.setViewName("index");
    	 return mv;
     }
     @GetMapping("/delete")
     public ModelAndView BookDelete(@RequestParam("bookId") Integer bookId) {
    	 service.deleteBook(bookId);
    	 List<Book> listbook= service.getAllBook();
    	 ModelAndView mv=new ModelAndView();
    	 mv.addObject("books", listbook);
    	 mv.setViewName("bookView");
    	 return mv;
     }
     
     @GetMapping("/edit")
     public ModelAndView BookEdit(@RequestParam("bookId") Integer bookId) {
    	 Book bookobj=service.getBookById(bookId);
    	
    	 ModelAndView mv=new ModelAndView();
    	 mv.addObject("book", bookobj);
    	 mv.setViewName("index");
    	 return mv;
     }
}
