package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public void addStudent(Student student) {
        try {
            repository.addStudent(student);
            System.out.println("Student added successfully");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error in adding student" + e.getMessage());
        }
    }

    public void searchStudentById(int id) {
        Student student = repository.searchStudentById(id);

        if (student != null) {
            System.out.println("Student FirstName is: " + student.getFirstName());
            System.out.println("Student batch: " + student.getBatch());
        } else {
            throw new EntityNotFoundException(
                    "Student with ID " + id + " not found"
            );
        }
    }

    public void deactivateStudent(int id) {
        boolean deactivatedStudentStatus = repository.deactivateStudent(id);
        if (deactivatedStudentStatus) {
            System.out.println("Student deactivated");
        } else {
            throw new EntityNotFoundException(
                    "Student with ID " + id + " not found"
            );
        }

    }

    public List<Student> viewStudents() {
        return repository.viewStudents();
    }
}
