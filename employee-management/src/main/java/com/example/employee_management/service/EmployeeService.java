package com.example.employee_management.service;

import com.example.employee_management.Employee;
import com.example.employee_management.exception.EmployeeNotFoundException;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create or update employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update an existing employee (Can also use saveEmployee for this if you prefer)
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setDepartment(employeeDetails.getDepartment());
            existingEmployee.setSalary(employeeDetails.getSalary());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }
}
