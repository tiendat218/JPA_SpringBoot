package com.example.springbootonetomanyundirectionalrestapimysql.repository;

import com.example.springbootonetomanyundirectionalrestapimysql.jpa.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
