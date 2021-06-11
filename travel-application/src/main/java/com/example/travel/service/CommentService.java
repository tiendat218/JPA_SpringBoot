package com.example.travel.service;

import com.example.travel.jpa.Comment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommentService {
    List<Comment> listComments();
    List<Comment> getCommentsByStatus(int status);
    List<Comment> getCommentsByLocation(int locationId);
    List<Comment> getCommentsByCustomer(int customerId);
    Comment getCommentById(int commentId);
    boolean saveComment(Comment comment);
    boolean deleteComment(int commentId);
    boolean updateComment(Comment comment);
    Page<Comment> findPaginated(int pageNo, int pageSize);
    Page<Comment> findPaginatedShow(int pageNo,int pageSize);
    Page<Comment> findPaginatedHidden(int pageNo,int pageSize);
    boolean checkCommentName(String commentName,int locationId, int customerId);

}
