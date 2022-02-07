package com.spring_mvc_mybatis.book.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc_mybatis.book.model.BookVO;
import com.spring_mvc_mybatis.book.service.BookService;
import com.spring_mvc_mybatis.book.service.IBookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	
	@RequestMapping("/")
	public String viewIndex() {
		System.out.println("실행");
		return "index";
	}
	
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		
		ArrayList<BookVO> bookList = service.listAllBook();
		model.addAttribute("bookList",bookList);
		
		return "book/bookListView";
	}
	
	
	@RequestMapping("/book/newBookForm")
	public String newProductForm() {
		
		return "book/newBookForm";
	}
	
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO book) {
		
		service.insertBook(book);
		
		return "redirect:./listAllBook";
		
	}

}
