package com.example.travel.repository;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByStatus(int status);

    @Query("SELECT p FROM Comment p WHERE locationId = ?1")
    List<Comment> findCommentsByLocation(int locationId);

    @Query("SELECT p FROM Comment p WHERE customerId = ?1")
    List<Comment> findCommentsByCustomer(int customerId);

    @Query("SELECT p FROM Comment p WHERE status = 1 OR status = 2")
    List<Comment> getAllComments();

    @Query("SELECT p FROM Comment p WHERE status = 1 OR status = 2")
    Page<Comment> findPaginateCommentsStatus(Pageable pageable);

    @Query("SELECT p FROM Comment p WHERE status = 1 ")
    Page<Comment> findPaginateCommentsStatusShow(Pageable pageable);

    @Query("SELECT p FROM Comment p WHERE status = 2 ")
    Page<Comment> findPaginateCommentsStatusHidden(Pageable pageable);

    @Query("SELECT p FROM Comment p WHERE commentName = ?1 AND locationId = ?2 AND customerId= ?3")
    Comment findByCommentName(String commentName,int locationId, int customerId);

}
