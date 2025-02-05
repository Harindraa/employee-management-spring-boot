package com.example.employee_management;  // Make sure to update this to match your package name

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity  // Marking this class as a JPA entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Primary key with auto-generation
    private Long id;

    @NotBlank(message = "Name cannot be blank")  // Ensures name is not empty
    private String name;

    private String department;

    private double salary;

    // Default constructor (required by JPA)
    public Employee() {}

    // Parameterized constructor for convenience
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters for the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", department='" + department + '\'' +
               ", salary=" + salary +
               '}';
    }
}
