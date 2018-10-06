package com.lms.controllers;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.services.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		//We send the list of books from the controller to the view
		//books is our list, and book every element
		req.setAttribute("books", lmsService.findAllBooks());
		//if we pass mode var with BOOK_VIEW value the conditional in the page says
		//that it will print the whole list of books
		req.setAttribute("mode", "BOOK_VIEW");
		return "index"; 
	}
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id, HttpServletRequest req ) {
		//We send the list of books from the controller to the view
		//books is our list, and book every element
		Book book = lmsService.findOne(id).get();
		req.setAttribute("book", book );
		req.setAttribute("mode", "BOOK_EDIT");
		return "index"; 
	}
	
	//Parse the date introduced by the user properly
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@PostMapping("/save")
	public void save(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res ) throws IOException {
		lmsService.save(book);
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		
		res.sendRedirect("/");
	}
	
	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_NEW");
		return "index";
	}
	
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam long id, HttpServletRequest req, HttpServletResponse res) throws IOException {
		lmsService.delete(id);
		res.sendRedirect("/");
	}
	

}
