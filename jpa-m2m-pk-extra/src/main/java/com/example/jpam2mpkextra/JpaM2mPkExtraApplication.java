package com.example.jpam2mpkextra;

import com.example.jpam2mpkextra.model.Book;
import com.example.jpam2mpkextra.model.BookPublisher;
import com.example.jpam2mpkextra.model.Publisher;
import com.example.jpam2mpkextra.repository.BookPublisherRepository;
import com.example.jpam2mpkextra.repository.BookRepository;
import com.example.jpam2mpkextra.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class JpaM2mPkExtraApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookPublisherRepository bookPublisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaM2mPkExtraApplication.class, args);
	}

    @Override
    @Transactional
    public void run(String... args) throws Exception {

	    Book b1 = new Book("Java Springboot");
	    Book b2 = new Book("REST with Springboot");
	    bookRepository.saveAll(Arrays.asList(b1,b2));

        Publisher p1 = new Publisher("NXB GD");
        Publisher p2 = new Publisher("NXB TG");
        publisherRepository.saveAll(Arrays.asList(p1,p2));

        BookPublisher bp1 = new BookPublisher(b1,p1,new Date());
        BookPublisher bp2 = new BookPublisher(b1,p2,new Date());
        bookPublisherRepository.saveAll(Arrays.asList(bp1,bp2));
    }
}
