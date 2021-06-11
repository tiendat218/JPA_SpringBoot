package com.example.springbootrestrelationshipmysql.repository;

import com.example.springbootrestrelationshipmysql.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
