package com.bookstore.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dao.AppDao;
import com.bookstore.dao.BookSearchRepository;
import com.bookstore.entity.Book;



@Controller
public class AppController {
	
	@Autowired
	private AppDao appDao;

	@Autowired
	BookSearchRepository bookSearchRepository; 
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/index"; 
	}

	//List all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {

		model.addAttribute("booksList", appDao.findAll());
		return "/books";
	}

	//Searches
	@RequestMapping("/search")
	public String mySearch(Model model, @RequestParam String search) {
		model.addAttribute("booksList", bookSearchRepository.searchBooks(search));
		model.addAttribute("search", search);
		return "/books";
	}

	//Listing books per genre
	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String getDbGenre(Model model) {
		model.addAttribute("booksList", bookSearchRepository.dbGenre());
		return "/books"; 
	}

	@RequestMapping(value = "/java", method = RequestMethod.GET)
	public String getJavaGenre(Model model) {
		model.addAttribute("booksList", bookSearchRepository.javaGenre());
		return "/books"; 
	}

	@RequestMapping(value = "/web", method = RequestMethod.GET)
	public String getWebGenre(Model model) {
		model.addAttribute("booksList", bookSearchRepository.webGenre());
		return "/books"; 
	}

	//Get one book
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public String getBookById(@PathVariable("id") String id, Model model) {
		model.addAttribute("bookList", appDao.findById(id).get());

		return "/book";
	}

	//Get the addBook form	
	@RequestMapping("/addBook")
	public String addingBook() {
		return "/addBook";
	}

	//Save the new book
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<String> addNewBook(@Valid @RequestBody Book book) {
		appDao.save(book);
		return ResponseEntity.ok("/redirect:/books") ;
		//return ResponseEntity.ok("User is valid");
	}
	

	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		appDao.deleteById(id);
		return "/redirect:/books";
	}

	//Get the edit book form
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable String id, Model model) {
		
		
		model.addAttribute("editBook", appDao.findById(id).get());
		return "/edit";
	}

	//Save changes
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String saveBook(Book book) {
		appDao.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("/error")
	public String errorsHandler(HttpServletRequest request) {
		
		String errorPage = "error";

		Object currentStat = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (currentStat != null) {
			
			Integer statusCodeReturned = Integer.valueOf(currentStat.toString());

			if (statusCodeReturned == HttpStatus.NOT_FOUND.value()) {
				errorPage = "/error/404";

			} else if (statusCodeReturned == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				errorPage = "/error/500";

			}
		}

		return errorPage;
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
