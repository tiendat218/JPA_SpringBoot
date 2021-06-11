package com.example.springbootrestrelationshipmysql.repository;

import com.example.springbootrestrelationshipmysql.jpa.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
