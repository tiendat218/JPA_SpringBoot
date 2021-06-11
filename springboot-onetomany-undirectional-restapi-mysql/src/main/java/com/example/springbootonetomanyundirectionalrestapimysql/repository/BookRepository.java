package com.example.springbootonetomanyundirectionalrestapimysql.repository;

import com.example.springbootonetomanyundirectionalrestapimysql.jpa.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByLibraryId(Integer libraryId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book book WHERE book.library.id = ?1")
    void deleteByLibraryId(Integer libraryId);
}
