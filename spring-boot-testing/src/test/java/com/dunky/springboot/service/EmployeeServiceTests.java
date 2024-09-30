package com.dunky.springboot.service;

import com.dunky.springboot.exception.ResourceNotFoundException;
import com.dunky.springboot.model.Employee;
import com.dunky.springboot.repository.EmployeeRepository;
import com.dunky.springboot.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
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

        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty()); // Stubbing
        given(employeeRepository.save(employee)).willReturn(employee);

        // when - action or the behavior that we are going to test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // then - versify the output
        assertThat(savedEmployee).isNotNull();
    }

    // JUnit test case for save employee method which throws an exception..
    @DisplayName("JUnit test case for save employee method which throws an exception.")
    @Test
    public void givenExitingEmail_whenSaveEmployee_thenThrowsException() {
        // given - precondition or setup

        given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.of(employee));

        // when - action or the behavior that we are going to test
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.saveEmployee(employee);
        });
        verify(employeeRepository, never()).save(any(Employee.class));
    }

    // JUnit test for getAllEmployees method
    @DisplayName("JUnit test for getAllEmployees method")
    @Test
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
        // given - precondition or setup

        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("Army")
                .lastName("Star")
                .email("star@gmail.com")
                .build();

        given(employeeRepository.findAll()).willReturn(List.of(employee,employee1)); // Stubbing

        // when -  action or the behaviour that we are going test
        List<Employee> employeeList = employeeService.getAllEmployees();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

}
