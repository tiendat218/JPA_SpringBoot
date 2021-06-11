package com.example.travel.service;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomers();
    List<Customer> getCustomersByStatus(int status);
    Customer getCustomerById(int customerId);
    boolean saveCustomer(Customer customer);
    boolean deleteCustomer(int customerId);
    boolean updateCustomer(Customer customer);
    Page<Customer> findPaginated(int pageNo, int pageSize);
    Page<Customer> findPaginatedShow(int pageNo,int pageSize);
    Page<Customer> findPaginatedHidden(int pageNo,int pageSize);
    boolean checkCustomerName(String customerName);
}
