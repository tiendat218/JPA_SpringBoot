package com.example.japmanytomanyprimarykey.repository;

import com.example.japmanytomanyprimarykey.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRespository extends JpaRepository<BookPublisher, Integer> {
}
