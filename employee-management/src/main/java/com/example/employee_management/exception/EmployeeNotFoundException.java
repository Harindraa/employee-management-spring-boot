package com.example.employee_management.exception;

public class EmployeeNotFoundException extends RuntimeException {

    // Constructor that takes a message as a parameter
    public EmployeeNotFoundException(String message) {
        super(message);  // Pass the message to the parent constructor
    }
}
