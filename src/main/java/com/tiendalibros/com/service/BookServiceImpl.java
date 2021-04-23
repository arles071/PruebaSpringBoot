package com.tiendalibros.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendalibros.com.entitys.Book;
import com.tiendalibros.com.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional(readOnly = true) // solo lectura
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // solo lectura
	public Page<Book> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true) // solo lectura
	public Optional<Book> findById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	@Transactional //forma escritura
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	@Transactional //forma escritura
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

}
