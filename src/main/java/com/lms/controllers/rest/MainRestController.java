package com.lms.controllers.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.models.Book;
import com.lms.services.LmsService;

@RestController
public class MainRestController {
	
	@Autowired
	private LmsService lmsService;
	
	//Serves as GET Req. to the URL "/"
	@GetMapping("/findAllBooks")
	public Collection<Book> getAllBooks() {
		return lmsService.findAllBooks();
	}
	
	//http://localhost:8080/delete?id=1
	@GetMapping("/delete")
	public void deleteBooks(@RequestParam long id) {
		lmsService.delete(id);
	}
	
	
}
