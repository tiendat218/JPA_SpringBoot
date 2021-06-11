package com.example.emailverification.account.repository;

import com.example.emailverification.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmail(String email);
}
