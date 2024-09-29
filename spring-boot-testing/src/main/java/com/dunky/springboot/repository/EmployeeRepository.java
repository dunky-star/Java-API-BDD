package com.dunky.springboot.repository;

import com.dunky.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom JPA Query to find employee by email
    Optional<Employee> findByEmail(String email);

    // Define custom query using Native SQL with named params
    @Query(value = "SELECT * FROM employees e WHERE e.first_name =:firstName AND e.last_name =:lastName",
    nativeQuery = true)
    Employee findByNativeQueryNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
