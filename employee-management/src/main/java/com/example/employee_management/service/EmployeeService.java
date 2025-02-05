package com.example.employee_management.service;  // Use your correct package path

import com.example.employee_management.Employee;  // Import the Employee entity class
import com.example.employee_management.repository.EmployeeRepository;  // Import the repository class
import org.springframework.beans.factory.annotation.Autowired;  // Import the @Autowired annotation
import org.springframework.stereotype.Service;  // Import the @Service annotation
import java.util.List;  // For working with lists
import java.util.Optional;  // For handling Optional results

@Service  // Marks this class as a Spring Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor injection of the EmployeeRepository
    @Autowired  // Automatically injects the EmployeeRepository dependency
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create or update an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);  // Calls the save method from the repository
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();  // Calls the findAll method from the repository
    }

    // Get an employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);  // Calls the findById method from the repository
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);  // Calls the deleteById method from the repository
    }
}
