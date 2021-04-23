package com.tiendalibros.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendalibros.com.entitys.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
