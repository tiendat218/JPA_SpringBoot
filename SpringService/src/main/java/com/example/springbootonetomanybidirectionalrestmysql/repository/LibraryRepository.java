package com.example.springbootonetomanybidirectionalrestmysql.repository;

import com.example.springbootonetomanybidirectionalrestmysql.jpa.Book;
import com.example.springbootonetomanybidirectionalrestmysql.jpa.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface LibraryRepository extends JpaRepository<Library,Integer> {
//    Page<Book> findByLibraryId(Integer library_id, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM  Book b WHERE b.library.id =?1")
    void deleteByLibrary(Integer library_id);

}
