package org.readBook.service.model;

import java.io.Serializable;

public class BookContext implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String bookName;
	private String bookType;
	private String bookAuthor;
	public String getBookName() {
		return bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	
	

}
