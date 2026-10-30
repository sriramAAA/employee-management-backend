package org.example.employeemanagement.controller;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.service.EmployeeService;


import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
//@CrossOrigin(origins = "http://localhost:5173")

@CrossOrigin(origins = "https://employee-management-frontend-ui.netlify.app/")

public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // READ: Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


    //create :add employee

    @PostMapping
    public Employee createEmployee( @RequestBody Employee employee) {
       return service.createEmployee(employee);

    }


    //update

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    //delete

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }




}
