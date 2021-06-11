package com.example.travel.repository;

import com.example.travel.jpa.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUsersByStatus(int status);

    @Query("SELECT c FROM User c WHERE status = 1 OR status = 2")
    List<User> getAllUsers();

    @Query("SELECT c FROM User c WHERE status = 1 OR status = 2")
    Page<User> findPaginateUsersStatus(Pageable pageable);

    @Query("SELECT p FROM User p WHERE status = 1 ")
    Page<User> findPaginateUsersStatusShow(Pageable pageable);

    @Query("SELECT p FROM User p WHERE status = 2 ")
    Page<User> findPaginateUsersStatusHidden(Pageable pageable);

    @Query("SELECT c FROM User c WHERE userName = ?1")
    User findByUserName(String userName);

}
