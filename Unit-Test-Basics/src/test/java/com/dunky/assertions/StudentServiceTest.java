package com.dunky.assertions;

import com.dunky.Student;
import com.dunky.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    public void getStudentNamesByDepartmentTest(){
        StudentService studentService = new StudentService();

        Student student1 = new Student(1, "OpenAI ChatGPT", "Computer Science");
        Student student2 = new Student(2, "Google Gemini", "Computer Science");
        Student student3 = new Student(3, "Anthropic Claude", "Mathematics");
        Student student4 = new Student(4, "Meta Llama3", "Computer Science");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);

        String[] actualArrayNames = studentService.getStudentNamesByDepartment("Computer Science");
        String[] expectedArray = {"OpenAI ChatGPT", "Google Gemini", "Meta Llama3"};

        assertArrayEquals(expectedArray, actualArrayNames, () -> "Student names are not equal");


    }

    @Test
    public void getStudentNameListByDepartmentTest(){
        StudentService studentService = new StudentService();

        Student student1 = new Student(1, "OpenAI ChatGPT", "Computer Science");
        Student student2 = new Student(2, "Google Gemini", "Computer Science");
        Student student3 = new Student(3, "Anthropic Claude", "Mathematics");
        Student student4 = new Student(4, "Meta Llama3", "Computer Science");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);

        List<String> expectedNameList = studentService.getStudentNameListByDepartment("Computer Science");
        List<String> actualNameList = Arrays.asList("OpenAI ChatGPT", "Google Gemini","Meta Llama3" );

        assertIterableEquals(expectedNameList, actualNameList, () -> "Student name list not equal" );

    }

}