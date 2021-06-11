package com.example.springservice.service;

import com.example.springservice.jpa.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listEmployee();
    Employee getEmployeeById(int id);
    boolean saveEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
}
