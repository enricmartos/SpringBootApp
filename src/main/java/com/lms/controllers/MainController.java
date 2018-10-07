package com.lms.controllers;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.*;
import com.lms.services.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	private EmailMessage emailMessage;
	@Value("${gmail.username}")
	private String username;
	@Value("${gmail.password}")
	private String password;
	
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
	
	@GetMapping("/contact")
	public String contact(HttpServletRequest req) {
		req.setAttribute("email", emailMessage);
		return "contact";
	}
	
	//@RequestMapping(value="/send", method = RequestMethod.POST)
	@PostMapping("/send")
	//public void sendEmail(@RequestBody EmailMessage emailMessage, HttpServletRequest req, HttpServletResponse res) throws AddressException, MessagingException, IOException {
	public void sendEmail(@ModelAttribute EmailMessage email, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse res ) throws IOException, AddressException, MessagingException {
		sendMail(email);
		//System.out.println("to_address: " + email.getTo_address() + "\n subject: " + email.getSubject() + "\n body: " + email.getBody());
		System.out.println("Email sent successfully");
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		
		res.sendRedirect("/");
		//return "Email sent successfully";
	}
	
	private void sendMail(EmailMessage emailMessage) throws AddressException, MessagingException, IOException {
		//SMTP properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		//Password auth
		Session session = Session.getInstance(props, 
				new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
		});
		
		
		//Setting the fields of the email message
		Message msg = new MimeMessage(session);		
		msg.setFrom(new InternetAddress(username, false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo_address()));
		System.out.println("Flag sendMail");
		msg.setSubject(emailMessage.getSubject());
		msg.setContent(emailMessage.getBody(), "text/html");
		msg.setSentDate(new Date());
		
		Transport.send(msg);
	}
	
	
	
	
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam long id, HttpServletRequest req, HttpServletResponse res) throws IOException {
		lmsService.delete(id);
		res.sendRedirect("/");
	}
	

}
