package com.tiendalibros.com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendalibros.com.entitys.Book;
//import com.tiendalibros.com.service.BookService;
//import com.tiendalibros.com.service.BookService;
import com.tiendalibros.com.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	//funcion de prueba para libros
	@GetMapping("/prueba")
	public String prueba() {
		String nombre = "";
		List<Book> books = StreamSupport
				.stream(bookService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		if(books.size() != 0) {
			nombre = books.get(0).getName().toString();
		}
		
		return "hola soy una prueba de ejemplo "+ nombre;
	}
	
	//Crear nuevo libro
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
	}
	
	//Leer libro
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long bookId) {
		Optional<Book> oBook = bookService.findById(bookId);
		if(!oBook.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oBook);
	}
	
	//Editar usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Book BookDetails, @PathVariable(value = "id") Long bookId){
		Optional<Book> book = bookService.findById(bookId);
		if(!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(userDetails, user.get());
		book.get().setName(BookDetails.getName());
		book.get().setAutor(BookDetails.getAutor());
		book.get().setCategoria(BookDetails.getCategoria());
		book.get().setCuantityAvailable(BookDetails.getCuantityAvailable());
		book.get().setReserveAmount(BookDetails.getReserveAmount());
		book.get().setCost(BookDetails.getCost());
		book.get().setStatus(BookDetails.getStatus());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book.get()));
	}
	
	//Eliminar un usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long bookId){
		if(!bookService.findById(bookId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		bookService.deleteById(bookId);
		return ResponseEntity.ok().build();
	}
	
	//leer todos los usuarios
	@GetMapping
	public List<Book> readAll(){
		List<Book> books = StreamSupport
				.stream(bookService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return books;
	}
	
	//Actualizar la cantidad de libros
	@PutMapping("/cantidad/{id}")
	public ResponseEntity<?> cantidadDisponible (@RequestBody Book BookDetails, @PathVariable(value = "id") Long bookId){
		Optional<Book> book = bookService.findById(bookId);
		if(!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		int amount = book.get().getCuantityAvailable();
		int newCuantity = BookDetails.getCuantityAvailable();
		
		book.get().setCuantityAvailable(amount + newCuantity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book.get()));
		
	
	}
	
	//Reserva de un libro
	@PutMapping("/reserva/{id}")
	public ResponseEntity<?> reserva (@RequestBody Book BookDetails, @PathVariable(value = "id") Long bookId){
		Optional<Book> book = bookService.findById(bookId);
		if(!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		int amount = book.get().getCuantityAvailable();
		int newCuantity = BookDetails.getCuantityAvailable();
		
		book.get().setCuantityAvailable(amount + newCuantity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book.get()));
		
	
	}
	
	
	
}
