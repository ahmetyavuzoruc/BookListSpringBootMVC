package org.bookReminder.mock.test;

import java.util.Arrays;
import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.readBook.dao.jpa.entity.Book;
import org.readBook.dao.jpa.repository.BookRepository;
import org.readBook.service.BookService;
import org.readBook.service.model.BookContext;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceMT {

	@Mock
    private BookRepository bookRepository;
	

	
	@InjectMocks
	private BookService bookService;
	
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void queryBook() {
		
		Book book = new Book();
		book.setBookId(10L);
		book.setBookName("Cimri");
		book.setBookType("Polisiye");
	  
	    
		Book book3 = new Book();
		book3.setBookId(11L);
		book3.setBookName("Sefiller");
		book3.setBookType("Dram");
		
	   
		 
	    Mockito
	    	.when(bookRepository.findWithBookId(10L))
	    	.thenReturn(book);
	    
	    Mockito
	    	.when(bookRepository.findWithBookId(11L))
	    	.thenReturn(book3);
	    
		
		Book book2 = bookService.findByBookId(11L);
		
		Assert.assertNotNull(book2);
		Assert.assertTrue(book2.getBookId() > 0);
	}
	
	@Test
	public void queryAllBooks() {
		
		Book book1 = new Book();
		book1.setBookId(10L);
		book1.setBookName("Cimri");
		book1.setBookType("Polisiye");
	   
	    
	    Book book2 = new Book();
	    book2.setBookId(10L);
	    book2.setBookName("Sefiller");
	    book2.setBookType("Dram");
	   
	    
	    
		List<Book> books = Arrays.asList(book1, book2);
		
		Mockito
			.when(bookRepository.getAllBookList())
			.thenReturn(books);
		
		
		
		List<Book> books2 = bookService.getAllBookList();
		
		Assert.assertNotNull(books2);
		Assert.assertTrue(books2.size() > 0);
	}
	
	@Test
	public void saveBook() {
		
		BookContext bookContext = new BookContext();
		bookContext.setBookName("Cimri");
		bookContext.setBookType("Polisiye");
	   
		
	    Long maxBookId = 100L;
	    
	    Book book = new Book();
	    book.setBookId(maxBookId + 1);
	    book.setBookName(bookContext.getBookName());
	    book.setBookType(bookContext.getBookType());
	    
		
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(maxBookId);
	    
		Mockito
			.when(bookRepository.save(book))
			.thenReturn(book);
		
		
		long bookId = bookService.save(bookContext);
		
		Assert.assertEquals(101L, bookId);
	}
	
	
	
	private void prepareMockTestRuleBookQueryByBookNo() {
		
		Book book = new Book();
		book.setBookId(10L);
		book.setBookName("Cimri");
		book.setBookType("Polisiye");
	   
		 
	    Mockito
	    	.when(bookRepository.findWithBookId(10L))
	    	.thenReturn(book);
		
	}
	
	
	
	private void prepareMockTestRuleBookSave(BookContext bookContext) {
		
		Long bookId = 100L;
		Book book = new Book();
		book.setBookId(bookId + 1);
		book.setBookName(bookContext.getBookName());
		book.setBookType(bookContext.getBookType());
	 
	    Mockito
			.when(bookRepository.findMaxId())
			.thenReturn(bookId);
	    
		Mockito
			.when(bookRepository.save(book))
			.thenReturn(book);
	}
	
}
