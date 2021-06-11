package com.example.jpam2mpkextra.repository;

import com.example.jpam2mpkextra.model.BookPublisher;
import com.example.jpam2mpkextra.model.BookPublisherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, BookPublisherId> {
}
