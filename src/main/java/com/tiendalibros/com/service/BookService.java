package com.tiendalibros.com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiendalibros.com.entitys.Book;


public interface BookService {
	
	public Iterable<Book> findAll();
	
	public Page<Book> findAll(Pageable pageable);
	
	public Optional<Book> findById(Long id);
	
	public Book save(Book book);
	
	public void deleteById(Long id);

}
