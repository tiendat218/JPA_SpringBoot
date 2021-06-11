package com.example.travel.service.Impl;

import com.example.travel.jpa.Comment;
import com.example.travel.repository.CommentRepository;
import com.example.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listComments() {
        try{
            List<Comment> comments = commentRepository.getAllComments();
            return comments;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByStatus(int status) {
        try{
            List<Comment> comments = commentRepository.findCommentsByStatus(status);

            return comments;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByLocation(int locationId) {
        try{
            List<Comment> comments = commentRepository.findCommentsByLocation(locationId);

            return comments;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByCustomer(int customerId) {
        try{
            List<Comment> comments = commentRepository.findCommentsByCustomer(customerId);

            return comments;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment getCommentById(int commentId) {
        try{
            Comment comment = commentRepository.findById(commentId).get();
            return comment;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveComment(Comment comment) {
        try {
            commentRepository.save(comment);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteComment(int commentId) {
        try{
            Comment comment = commentRepository.findById(commentId).get();
            commentRepository.delete(comment);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        try{
            commentRepository.save(comment);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Comment> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.commentRepository.findPaginateCommentsStatus(pageable);
    }

    @Override
    public Page<Comment> findPaginatedShow(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.commentRepository.findPaginateCommentsStatusShow(pageable);
    }

    @Override
    public Page<Comment> findPaginatedHidden(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.commentRepository.findPaginateCommentsStatusHidden(pageable);
    }

    @Override
    public boolean checkCommentName(String commentName, int locationId, int customerId) {
        Comment comment = commentRepository.findByCommentName(commentName,locationId, customerId);
        if (comment==null)
        {
            return true;
        }else{
            return false;
        }
    }
}
