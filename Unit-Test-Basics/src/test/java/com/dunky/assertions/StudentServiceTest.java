package com.dunky.assertions;

import com.dunky.Student;
import com.dunky.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentTest(){
        StudentService studentService = new StudentService();

        List<Student> listOfStudent = studentService.getStudents();

        boolean actualResult = listOfStudent.isEmpty();

        assertTrue(() -> actualResult, () -> "List of student is empty!"); // Lazy evaluation using
                                                                           // Supplier Functional Interface.
    }

    @Test
    public void getStudentByIdTest(){
        StudentService studentService = new StudentService();

        Student student = new Student(2, "Dunky Opiyo");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(2);
        assertNotNull(actualObject, ()-> "Student is not null");

        assertEquals("Dunky Opiyo", student.getName(), () -> "Student name is not equal");
    }

}