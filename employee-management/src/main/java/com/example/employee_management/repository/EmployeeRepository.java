package com.example.employee_management.repository;  // Use your correct package path

import com.example.employee_management.Employee;  // Import the Employee entity class
import org.springframework.data.jpa.repository.JpaRepository;  // Import JpaRepository
import org.springframework.stereotype.Repository;  // Import Repository annotation

@Repository  // Marks this class as a Spring Data JPA Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository provides built-in methods to perform CRUD operations for Employee.
    // Methods like save(), findById(), findAll(), and deleteById() are available automatically.
}
