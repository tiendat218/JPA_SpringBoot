package com.example.jpamanytomany.repository;


import com.example.jpamanytomany.jpa.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Integer> {
}
