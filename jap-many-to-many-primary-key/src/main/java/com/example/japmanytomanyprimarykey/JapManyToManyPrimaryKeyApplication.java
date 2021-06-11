package com.example.japmanytomanyprimarykey;

import com.example.japmanytomanyprimarykey.model.Book;
import com.example.japmanytomanyprimarykey.model.BookPublisher;
import com.example.japmanytomanyprimarykey.model.Publisher;
import com.example.japmanytomanyprimarykey.repository.BookPublisherRespository;
import com.example.japmanytomanyprimarykey.repository.BookRepository;
import com.example.japmanytomanyprimarykey.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class JapManyToManyPrimaryKeyApplication implements CommandLineRunner {


    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookPublisherRespository bookPublisherRespository;

	public static void main(String[] args) {
		SpringApplication.run(JapManyToManyPrimaryKeyApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception{
        Book book1 = new Book("Spring Boot");
        Book book2 = new Book("Java Spring ");
        bookRepository.saveAll(Arrays.asList(book1, book2));

        Publisher publisher1 = new Publisher("NHX XH");
        Publisher publisher2 = new Publisher("NHX GD");
        publisherRepository.saveAll(Arrays.asList(publisher1, publisher2));

        BookPublisher bookPublisher1 = new BookPublisher(book1, publisher1, new Date());
        BookPublisher bookPublisher2 = new BookPublisher(book1, publisher2, new Date());
        bookPublisherRespository.saveAll(Arrays.asList(bookPublisher1, bookPublisher2));
    }

}
