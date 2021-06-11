package com.example.jpamanytomany;

import com.example.jpamanytomany.jpa.Book;
import com.example.jpamanytomany.jpa.Publisher;
import com.example.jpamanytomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaManyToManyApplication implements CommandLineRunner {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
    @Autowired
    private BookRepository bookRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        bookRepository.save(new Book("JavaSpring1", new Publisher("NXB GD"), new Publisher("NXB HH")));
    }

}
