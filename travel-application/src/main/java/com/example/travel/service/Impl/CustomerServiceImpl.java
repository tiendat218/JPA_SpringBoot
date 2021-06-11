package com.example.travel.service.Impl;

import com.example.travel.jpa.Customer;
import com.example.travel.repository.CustomerRepository;
import com.example.travel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        try{
            List<Customer> customers = customerRepository.getAllCustomers();
            return customers;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByStatus(int status) {
        try{
            List<Customer> customers = customerRepository.findCustomersByStatus(status);

            return customers;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        try{
            Customer customer = customerRepository.findById(customerId).get();
            return customer;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try{
            Customer customer = customerRepository.findById(customerId).get();
            customerRepository.delete(customer);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.customerRepository.findPaginateCustomersStatus(pageable);
    }

    @Override
    public Page<Customer> findPaginatedShow(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.customerRepository.findPaginateCustomersStatusShow(pageable);
    }

    @Override
    public Page<Customer> findPaginatedHidden(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.customerRepository.findPaginateCustomersStatusHidden(pageable);
    }

    @Override
    public boolean checkCustomerName(String customerName) {
        Customer customer = customerRepository.findByCustomerName(customerName);
        if (customer==null)
        {
            return true;
        }else{
            return false;
        }
    }
}
