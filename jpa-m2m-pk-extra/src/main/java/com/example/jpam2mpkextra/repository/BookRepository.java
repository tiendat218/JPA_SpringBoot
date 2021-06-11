package com.example.jpam2mpkextra.repository;

import com.example.jpam2mpkextra.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
