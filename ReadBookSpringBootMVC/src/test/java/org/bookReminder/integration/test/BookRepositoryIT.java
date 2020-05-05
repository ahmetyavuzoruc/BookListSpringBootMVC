package org.bookReminder.integration.test;




import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.readBook.dao.jpa.entity.Book;
import org.readBook.dao.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource({ "classpath:application.properties" })
public class BookRepositoryIT {

	@Autowired
	private BookRepository bookRepository;
	
	
	@Test
	@Order(1)
	public void selectBookByBookNo() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBookId(maxId);
		
		Assert.assertNotNull(book);
		Assert.assertTrue(book.getBookId() > 0);
	}
	
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(4)
	public void updateBook() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBookId(maxId);
		
		book.setBookName("Cimri");
		book.setBookType("Polisiye");
		
		
		bookRepository.save(book);
		
		book = bookRepository.findWithBookId(maxId);
		
		Assert.assertEquals("Cimri", book.getBookName());
		Assert.assertEquals("Polisiye", book.getBookType());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Order(5)
	public void deleteBook() {
		
		Long maxId = bookRepository.findMaxId();
		Book book = bookRepository.findWithBookId(maxId);
		
		bookRepository.delete(book);
		
		book = bookRepository.findWithBookId(maxId);
		
		Assert.assertNull(book);
	}
}
