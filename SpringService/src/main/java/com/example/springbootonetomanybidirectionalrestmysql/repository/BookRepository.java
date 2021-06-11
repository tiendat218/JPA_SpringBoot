package com.example.springbootonetomanybidirectionalrestmysql.repository;

import com.example.springbootonetomanybidirectionalrestmysql.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
