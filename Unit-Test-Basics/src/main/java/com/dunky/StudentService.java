package com.dunky;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    public List<Student> students = new ArrayList<>();

    public List<Student> getStudents(){
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudentById(int id){
        return students.stream()
                .filter((s) -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public String[] getStudentNamesByDepartment(String department){
        return students.stream()
                .filter((s) -> s.getDepartment().equals(department))
                .map(Student::getName)
                .toArray(String[]::new);
    }

    public List<String> getStudentNameListByDepartment(String department){
        return students.stream()
                .filter((s) -> s.getDepartment().equals(department))
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
