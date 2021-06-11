package com.example.travel.api;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Customer;
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
@RequestMapping("api/v1/customers")
public class CustomerAPI {
    private final CommentRepository commentRepository;
    private final CustomerRepository customerRepository;

    public CustomerAPI(CommentRepository commentRepository, CustomerRepository customerRepository) {
        this.commentRepository = commentRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping //read data
    public ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int customerId){
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);

        if(!optionalCustomer.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }

    @PostMapping
    public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody Customer customer){
        Customer customerSaved = customerRepository.save(customer);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(customerSaved.getCustomerId())
            .toUri();

        return ResponseEntity.created(location).body(customerSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId,
                                                 @Valid @RequestBody Customer customer){
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);

        if(!optionalCustomer.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        customer.setCustomerId(optionalCustomer.get().getCustomerId());
        customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId){
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);

        if(!optionalCustomer.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        customerRepository.delete(optionalCustomer.get());
        return ResponseEntity.noContent().build();
    }
}
