package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entity.Book;

@Component
public class BookService {
	
	
	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> list = new ArrayList();
//	
//	static {
//		
//		list.add( new Book(1,"Java","XTS"));
//		list.add(new Book(2,"Head First","sfjkwf"));
//	}
	
	
	public List<Book> getAllBooks(){
		 List<Book> books = bookRepository.findAll();
		 
		 return books;
	}
	
	
	public Book getBookById(int id) {
		
		Book book = null;
//		Optional<Book> books = list.stream().filter(e ->e.getId()==id).findFirst();
//		
//		book = books.get();
		
		/*
		 * This stream filter function take one by one object of the list and 
		 * perform the condition and return in boolean. if any object justify the given
		 * condition then it return that object
		 */
		
		try {
			
			//book = list.stream().filter(e -> e.getId()==id).findFirst().get();
			book= bookRepository.findById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
		
		
	}
	
	//adding the book
	public Book addBook(Book book) {
		Book saveBook = bookRepository.save(book);
		
		return saveBook;
	}
	
	
	//delete book
	public void deleteBook(int id) {
//		list = list.stream().filter(book ->{
//			if(book.getId()!= id) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		//list =  list.stream().filter(book -> book.getId()!=id).collect(Collectors.toList());
		
		bookRepository.deleteById(id);
	}
	
	
	public void updateBook(Book book, int id) {
		
		
		/*
		 * The Stream Map() function take one by one object from list and can make
		 * changes on the object and then return that object
		 */
		
//		list = list.stream().map(b -> {
//			
//			if(b.getId() == id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
		
		//save method can insert/update the database table
		//if id present then update otherwise insert into the table
		
		book.setId(id);
		bookRepository.save(book);
	}
}






















