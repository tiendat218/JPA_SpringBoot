package com.example.springbootrestrelationshipmysql.repository;

import com.example.springbootrestrelationshipmysql.jpa.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
