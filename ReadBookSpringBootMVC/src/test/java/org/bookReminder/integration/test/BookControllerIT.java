package org.bookReminder.integration.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.readBook.dao.jpa.entity.Book;
import org.readBook.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.core.annotation.Order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({ "classpath:application.properties" })
public class BookControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int tomcatPortNo;

	@Test
	@Order(1)
	public void testRestTemplate() {

		ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com", String.class);

		System.out.println(tomcatPortNo);

		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(response.getBody().length() > 0);
	}

	@Test
	@Order(2)
	public void findBookById() {

		String url = prepareBookRestServiceRootUrl() + "book/10002";

		ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);

		Book book = response.getBody();

		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertTrue(10003 == book.getBookId());
	}

	@Test
	@Order(3)
	public void saveBook() {

		String url = prepareBookRestServiceRootUrl() + "book";

		BookContext bookContext = new BookContext();
		bookContext.setBookName("TestUser1");
		bookContext.setBookType("testUser1");

		ResponseEntity<Long> response = restTemplate.postForEntity(url, bookContext, Long.class);

		Long bookNo = response.getBody();

		Assert.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		Assert.assertNotNull(bookNo);
	}

	private String prepareBookRestServiceRootUrl() {

		return "http://localhost:" + tomcatPortNo + "/application/";
	}
}
