package org.readBook.dao.jpa.repository;

import java.util.List;

import org.readBook.dao.jpa.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	
		@Query(value = "FROM Book e WHERE e.bookId = :bookId")
		public Book findWithBookId(@Param("bookId") Long bookId);
		
		@Query(value = "SELECT MAX(e.bookId) FROM Book e")
		public Long findMaxId();
		
		@Query(value = "SELECT e FROM Book e")
		public List<Book> getAllBookList();
		
		@Query(value = "SELECT e FROM Book e WHERE e.bookName=:bookName")
		public List<Book> findByBookName(@Param("bookName") String bookName);

}
