package com.boot.controller;

//import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RequestParam;

import com.boot.model.Book;
import com.boot.service.BookService;

@Controller
@RequestMapping(value="Book")
public class BookController {
	@Autowired
	public BookService bookservice;

	@GetMapping
	public String list(ModelMap modelMap) {
		System.out.println("CONTROLLER CALLED");

		List<Book> books = bookservice.findAll();
		modelMap.addAttribute("books", books);
		return "listbooks";

	}
	
	

	
	@GetMapping("/{id}")
	public String View(@PathVariable("id") int id,HttpSession session)
	{
	System.out.println("viewbook"+id);	
	Book book=bookservice.findOne(id);
	session.setAttribute("selectbook", book);
	return "bookdetails";
	
	}

	

	/*@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public void addBook(@RequestParam("id") int id  , @RequestParam("title") String title,
			@RequestParam("author") String author , @RequestParam("publishdate") LocalDate publishdate ,
			@RequestParam("content") String content ,@RequestParam("price") float price) {
		System.out.println("Controller called");
		Book book = new Book(); 
		System.out.println("Inside the controller");
		bookservice.save(book);

	}
*/
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/loginuser";
    }


	
}
