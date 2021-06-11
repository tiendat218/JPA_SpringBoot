package com.example.springbootonetomanybidirectionalrestmysql.service;


import com.example.springbootonetomanybidirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanybidirectionalrestmysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> listBook() {
        try{
            List<Book>  listBook = bookRepository.findAll();
            return listBook;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookById(int book_id) {
        try{
            Book book = bookRepository.getOne(book_id);
            return book;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveBook(Book book) {
        try{
            bookRepository.save(book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(int book_id) {
        try{
            bookRepository.deleteById(book_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        try{
            bookRepository.save(book);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
