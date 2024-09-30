package com.dunky.springboot.service;

import com.dunky.springboot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
