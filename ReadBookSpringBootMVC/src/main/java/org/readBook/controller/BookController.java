package org.readBook.controller;

import java.util.List;

import org.readBook.dao.jpa.entity.Book;
import org.readBook.service.BookService;
import org.readBook.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByBookId(@PathVariable("id") Long id) {
		
		return bookService.findByBookId(id);
	}
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<Book> getAllBookList() {
		
		return bookService.getAllBookList();
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public Long save(@RequestBody BookContext bookContext) {
		
		return bookService.save(bookContext);
	}
	
	
}
