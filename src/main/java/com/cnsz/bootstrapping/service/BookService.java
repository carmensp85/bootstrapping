package com.cnsz.bootstrapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnsz.bootstrapping.dao.BookDAO;
import com.cnsz.bootstrapping.model.Book;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDao;
	
	public Book getBook(Long id) {
		return bookDao.getBook(id);
	}
	
}
