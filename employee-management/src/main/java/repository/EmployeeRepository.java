package com.example.employee_management.repository;

import com.example.employee_management.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this as a repository component for Spring to manage
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JpaRepository provides basic CRUD methods: save(), findById(), deleteById(), etc.
}
