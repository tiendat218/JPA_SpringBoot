package com.example.springbootgraphql.service.datafetcher;

import com.example.springbootgraphql.model.Book;
import com.example.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        return bookRepository.findAll();
    }
}
