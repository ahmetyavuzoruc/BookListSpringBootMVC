package org.readBook.service;

import java.util.List;

import org.readBook.annotation.MethodRunningTime;
import org.readBook.dao.jpa.entity.Book;
import org.readBook.dao.jpa.repository.BookRepository;
import org.readBook.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book findByBookId(Long bookId) {

		return bookRepository.findWithBookId(bookId);
	}
	

	public List<Book> getAllBookList() {

		return bookRepository.getAllBookList();
	}

	@MethodRunningTime(timeCalculation = true)
	@Transactional
	public Long save(BookContext bookContext) {

		Long maxId = bookRepository.findMaxId() + 1;

		Book book = new Book();
		book.setBookId(maxId);
		book.setBookName(bookContext.getBookName());
		book.setBookType(bookContext.getBookType());
		book.setBookAuthor(bookContext.getBookAuthor());
		

		book = bookRepository.save(book);

		
		return book.getBookId();
	}
	
	public List<Book> searchBy(String bookName) {

		List<Book> result = null;
		
			result = bookRepository.findByBookName(bookName);
		
		return result;
	}
	

}
