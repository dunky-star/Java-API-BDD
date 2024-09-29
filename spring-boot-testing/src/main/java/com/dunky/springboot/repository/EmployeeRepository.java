package com.dunky.springboot.repository;

import com.dunky.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom JPA Query to find employee by email
    Optional<Employee> findByEmail(String email);
}
