package com.example.Employee.Service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Controller.Employee;
import com.example.Employee.Repo.EmployeeRepo.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        // Implement business logic for creating an employee
        return employeeRepository.save(employee);
    }

    public List getAllEmployees() {
        // Fetch all employees using JPA repository
        return (List) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) throws Exception {
        // Implement business logic for getting employee by ID
        java.util.Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new Exception();
        }
        return employee.get();
    }

    public Employee updateEmployee(Long id, Employee employee) throws Exception {
        employee.setId(id); // Set ID manually to avoid accidental overrides
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) throws Exception {
        // Implement business logic for deleting an employee
        getEmployeeById(id); // Ensures employee exists before deletion
        employeeRepository.deleteById(id);
    }
}
