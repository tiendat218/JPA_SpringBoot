package com.example.japmanytomanyprimarykey.repository;

import com.example.japmanytomanyprimarykey.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
