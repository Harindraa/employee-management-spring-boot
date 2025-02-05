package com.example.employee_management.controller;  // Use your correct package path

import com.example.employee_management.Employee;  // Import Employee entity class
import com.example.employee_management.service.EmployeeService;  // Import EmployeeService
import org.springframework.beans.factory.annotation.Autowired;  // For autowiring
import org.springframework.http.HttpStatus;  // For HTTP status codes
import org.springframework.http.ResponseEntity;  // For ResponseEntity
import org.springframework.web.bind.annotation.*;  // For RESTful annotations

import java.util.List;
import java.util.Optional;

@RestController  // Marks this class as a REST controller to handle HTTP requests
@RequestMapping("/api/employees")  // Base URL path for employee-related endpoints
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired  // Automatically injects the EmployeeService dependency
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to create or update an employee
    @PostMapping  // POST request to /api/employees
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);  // Return the saved employee
    }

    // Endpoint to get all employees
    @GetMapping  // GET request to /api/employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);  // Return list of employees
    }

    // Endpoint to get an employee by ID
    @GetMapping("/{id}")  // GET request to /api/employees/{id}
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)  // Return employee if found
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());  // Return 404 if not found
    }

    // Endpoint to delete an employee
    @DeleteMapping("/{id}")  // DELETE request to /api/employees/{id}
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content after deletion
    }
}
