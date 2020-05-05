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
import org.readBook.controller.BookController;
import org.readBook.dao.jpa.entity.Book;
import org.readBook.service.BookService;



@RunWith(MockitoJUnitRunner.class)
public class BookControllerMT {

	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void getAllBookList() {

		Book book = new Book();
		book.setBookAuthor("abc");
		book.setBookId(4L);
		book.setBookType("abc");

		
		List<Book> booksList1 = Arrays.asList(book);

	
		Mockito.when(bookService.getAllBookList())
				
				.thenReturn(booksList1);

		List<Book> booksList = bookController.getAllBookList();
		
		Assert.assertNotNull(booksList);

	}

	
}
