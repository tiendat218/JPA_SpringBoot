package com.example.springbootservice.repository;

import com.example.springbootservice.jpa.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT c FROM Employee c ")
    Page<Employee> findPaginateEmployee(Pageable pageable);
}
