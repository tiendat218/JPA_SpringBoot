package com.example.travel.repository;

import com.example.travel.jpa.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomersByStatus(int status);

    @Query("SELECT c FROM Customer c WHERE status = 1 OR status = 2")
    List<Customer> getAllCustomers();

    @Query("SELECT c FROM Customer c WHERE status = 1 OR status = 2")
    Page<Customer> findPaginateCustomersStatus(Pageable pageable);

    @Query("SELECT p FROM Customer p WHERE status = 1 ")
    Page<Customer> findPaginateCustomersStatusShow(Pageable pageable);

    @Query("SELECT p FROM Customer p WHERE status = 2 ")
    Page<Customer> findPaginateCustomersStatusHidden(Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE customerName = ?1")
    Customer findByCustomerName(String customerName);
}
