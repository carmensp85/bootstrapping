package com.cnsz.bootstrapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cnsz.bootstrapping.model.Book;
import com.cnsz.bootstrapping.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/getBook", method=RequestMethod.GET)
	public ResponseEntity<Book> getBookDetails() {
		Book book = bookService.getBook(new Long(1));
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
}
