package org.example.employeemanagement.service;

import org.example.employeemanagement.entity.Employee;
import org.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository Repository;

    public EmployeeService(EmployeeRepository Repository) {
        this.Repository=Repository;
    }

    //read

    public List<Employee> getAllEmployees() {
        return Repository.findAll();
    }

   //creat

    public Employee createEmployee(Employee employee) {
        return Repository.save(employee);
    }


    // UPDATE
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = Repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return Repository.save(existing);
    }


    //deleting


    public void deleteEmployee(Long id) {
        if (!Repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        Repository.deleteById(id);
    }

}
