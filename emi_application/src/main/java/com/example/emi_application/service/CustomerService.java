package com.example.emi_application.service;

import com.example.emi_application.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    boolean saveCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(Long cust_id);
    Customer getCustById(Long cust_id);
}
