package com.dunky;

import java.util.ArrayList;
import java.util.List;

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
}
