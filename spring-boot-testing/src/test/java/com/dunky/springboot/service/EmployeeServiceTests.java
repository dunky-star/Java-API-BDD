package com.dunky.springboot.service;

import com.dunky.springboot.model.Employee;
import com.dunky.springboot.repository.EmployeeRepository;
import com.dunky.springboot.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    public void setUp(){
         employee = Employee.builder()
                .id(1L)
                .firstName("Geoffrey")
                .lastName("Opi")
                .email("dunky@mail.com")
                .build();
    }

    // JUnit test case for save employee method.
    @DisplayName("JUnit test case for save employee method.")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){
        // given - precondition or setup

        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        // when - action or the behavior that we are going to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // then - versify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }
}
