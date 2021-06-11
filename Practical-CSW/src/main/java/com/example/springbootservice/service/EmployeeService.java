package com.example.springbootservice.service;

import com.example.springbootservice.jpa.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> listEmployees();
    Employee getEmployeeById(int id);
    boolean saveEmployee(Employee employee);
    boolean deleteEmployee(int id);
    boolean updateEmployee(Employee employee);
    Page<Employee> findPaginatedEmployee(int pageNo, int pageSize);

}
