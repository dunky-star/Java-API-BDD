package com.dunky.springboot.repository;

import com.dunky.springboot.model.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for save employee operation
    @DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Geoffrey")
                .lastName("Op")
                .email("op@mail.com")
                .build();

        // when - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.save(employee);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);

    }

    // JUnit test for find all employees
    @DisplayName("JUnit test for find all employees")
    @Test
    public void givenEmployeeList_whenFindAll_thenReturnEmployeeList(){

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Geoffrey")
                .lastName("Op")
                .email("op@mail.com")
                .build();
        Employee employee1 = Employee.builder()
                .firstName("Got")
                .lastName("Mola")
                .email("mola@mail.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        // when - action or the behavior that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }

    // JUnit test for find employee by ID
    @DisplayName("JUnit test for find employee by ID")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Mon")
                .lastName("Yela")
                .email("yela@mail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or the behavior that we are going to test
        Employee employeeDB = employeeRepository.findById(employee.getId()).get(); // Because it returns optional

        // then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    // JUnit test for get employee by email
    @DisplayName("JUnit test for get employee by email")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject(){

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ter")
                .lastName("Kworo")
                .email("kworo@mail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or the behavior that we are going to test
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get(); // Because it returns optional

        // then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    // JUnit test for update employee
    @DisplayName("JUnit test for update employee")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployeeObject(){

        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ter")
                .lastName("Kworo")
                .email("kworo@mail.com")
                .build();

        employeeRepository.save(employee);

        // when - action or the behavior that we are going to test
        Employee employeeToUpdate = employeeRepository.findByEmail(employee.getEmail()).get(); // Because it returns optional
        employeeToUpdate.setFirstName("Kal");
        employeeToUpdate.setEmail("kworo@mail.com");
        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);

        // then - verify the output
        assertThat(updatedEmployee.getLastName()).isEqualTo("Kwaro");
        assertThat(updatedEmployee.getEmail()).isEqualTo("kworo@mail.com");

    }

}
