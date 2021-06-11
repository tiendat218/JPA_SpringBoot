package com.example.springbootrestrelationshipmysql.repository;

import com.example.springbootrestrelationshipmysql.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
