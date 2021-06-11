package com.example.japmanytomanyprimarykey.repository;

import com.example.japmanytomanyprimarykey.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
