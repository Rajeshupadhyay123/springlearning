package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	
//	@GetMapping("/book")
//	public Book getBook() {
//		
//		Book book = new Book(1, "Java", "Rajesh upadhyay");
//		
//		return book;
//	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getCustomBook() {
		
		 List<Book> books = this.bookService.getAllBooks();
		 
		 if(books.size()<=0) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook1(@PathVariable("id") int id) {
		
		Book book =null;
		book = bookService.getBookById(id);
		
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		Book newBook = null;
		
		try {
			
			newBook = bookService.addBook(book);
			
			return ResponseEntity.of(Optional.of(newBook));
			
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		
		try {
			
			bookService.deleteBook(id);
			
//			return ResponseEntity.ok().build();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		
		try {
			
			bookService.updateBook(book, id);
			
			return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}











