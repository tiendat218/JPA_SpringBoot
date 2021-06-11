package com.example.springbootservice.api;


import com.example.springbootservice.jpa.Employee;
import com.example.springbootservice.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeAPI {
    private final EmployeeRepository employeeRepository;

    public EmployeeAPI(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping //read data
    public ResponseEntity<Page<Employee>> getAll(Pageable pageable)
    {
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id){

        Optional<Employee> optionalEmployee= employeeRepository.findById(id);

        if(!optionalEmployee.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalEmployee.get());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        Employee employeeSaved = employeeRepository.save(employee);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(employeeSaved.getId())
            .toUri();

        return ResponseEntity.created(location).body(employeeSaved);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,
                                           @Valid @RequestBody Employee employee){
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);

        if(!optionalEmployee.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        employee.setId(optionalEmployee.get().getId());
        employeeRepository.save(employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id,
                                           @Valid @RequestBody Employee employee){
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);

        if(!optionalEmployee.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        employeeRepository.delete(optionalEmployee.get());
        return ResponseEntity.noContent().build();
    }
}
