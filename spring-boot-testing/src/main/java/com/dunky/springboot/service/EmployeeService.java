package com.dunky.springboot.service;

import com.dunky.springboot.model.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
}
