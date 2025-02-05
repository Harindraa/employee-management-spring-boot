package com.example.employee_management.controller;

import com.example.employee_management.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;  // For global exception handling

@RestControllerAdvice  // This annotation marks this class as a global exception handler
public class GlobalExceptionHandler {

    // Handle EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class)  // This method handles EmployeeNotFoundException
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  // Return 404 Not Found with the exception message
    }

    // Handle other general exceptions
    @ExceptionHandler(Exception.class)  // This method handles any other exceptions
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 Internal Server Error
    }
}
