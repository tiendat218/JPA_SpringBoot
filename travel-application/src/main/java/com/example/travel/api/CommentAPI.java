package com.example.travel.api;


import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Customer;
import com.example.travel.jpa.Location;
import com.example.travel.repository.CommentRepository;
import com.example.travel.repository.CustomerRepository;
import com.example.travel.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
public class CommentAPI {
    private final CommentRepository commentRepository;
    private final LocationRepository locationRepository;
    private final CustomerRepository customerRepository;

    public CommentAPI(CommentRepository commentRepository, LocationRepository locationRepository, CustomerRepository customerRepository) {
        this.commentRepository = commentRepository;
        this.locationRepository = locationRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping //read data
    public ResponseEntity<Page<Comment>> getAll(Pageable pageable) {
        return ResponseEntity.ok(commentRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable int commentId) {

        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        if (!optionalComment.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalComment.get());
    }

    @PostMapping
    public ResponseEntity<Comment> insertComment(@Valid @RequestBody Comment comment) {
        Optional<Location> optionalLocation = locationRepository.findById(comment.getLocation().getLocationId());
        if (!optionalLocation.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Customer> optionalCustomer = customerRepository.findById(comment.getCustomer().getCustomerId());
        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        comment.setLocation(optionalLocation.get());
        comment.setCustomer(optionalCustomer.get());
        Comment commentSaved = commentRepository.save(comment);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(commentSaved.getCommentId())
            .toUri();

        return ResponseEntity.created(location).body(commentSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable int commentId,
                                              @Valid @RequestBody Comment comment) {
        Optional<Location> optionalLocation = locationRepository.findById(comment.getLocation().getLocationId());
        if (!optionalLocation.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Customer> optionalCustomer = customerRepository.findById(comment.getCustomer().getCustomerId());
        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (!optionalComment.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        comment.setLocation(optionalLocation.get());
        comment.setCustomer(optionalCustomer.get());
        comment.setCommentId(optionalComment.get().getCommentId());
        commentRepository.save(comment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable int commentId,
                                           @Valid @RequestBody Comment comment){
        Optional<Comment> optionalComment= commentRepository.findById(commentId);

        if(!optionalComment.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        commentRepository.delete(optionalComment.get());
        return ResponseEntity.noContent().build();
    }


}
