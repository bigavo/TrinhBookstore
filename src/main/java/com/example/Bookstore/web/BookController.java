package com.example.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;
@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository cdepository;
	
	//Show all books
	
	@RequestMapping("/booklist")
	public String studentList(Model model) {
		model.addAttribute("books",repository.findAll());
		return "booklist";
	}
	// Add new book
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) repository.findAll();
	}
	
	
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 model.addAttribute("categories",cdepository.findAll());
	 return "addbook";
	}
	// Save new book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	// Delete book
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
	 repository.deleteById(id);
	 return "redirect:../booklist";
	 
	}@RequestMapping(value = {"/","/home"})
	public String homeSecure() {
		return "home";
	}
	
	@RequestMapping(value = "/hello")
	public String helloSecure() {
		return "hello";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
}
