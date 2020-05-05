package org.readBook.controller.webUi;


import java.util.List;


import org.readBook.dao.jpa.entity.Book;
import org.readBook.dao.jpa.repository.BookRepository;
import org.readBook.service.BookService;
import org.readBook.service.model.BookContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBook(Model model) {
		
		List<Book> book = bookService.getAllBookList();
		model.addAttribute("book", book);
		
		return "thyme_book_list";
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookContext bookContext) {
		
		return "thyme_book_save";
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(BookContext bookContext, BindingResult result, Model model) {
  
		
		bookService.save(bookContext);
        
		model.addAttribute("book", bookService.getAllBookList());
        
        return "thyme_book_list";
    }
	
	@GetMapping("/search")
	public String delete(@RequestParam("bookName") String bookName, Model model) {

		
		List<Book> book = bookService.searchBy(bookName);

		
		model.addAttribute("book", book);

		
		return "thyme_book_list";

	}

		

	
}
