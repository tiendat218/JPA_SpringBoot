package com.example.springbootonetomanybidirectionalrestmysql.service;

import com.example.springbootonetomanybidirectionalrestmysql.jpa.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> listBook();
    Book getBookById(int book_id);
    boolean saveBook(Book book);
    boolean deleteBook(int book_id);
    boolean updateBook(Book book);
}
