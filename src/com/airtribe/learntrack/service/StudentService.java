package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {
    private StudentRepository repository = new StudentRepository();
    public  void addStudent(Student student){
        try {
            repository.addStudent(student);
            System.out.println("Student added successfully");
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println("Error in adding student"+e.getMessage());
        }
    }
    public void searchStudentById(int id) {
        Student student = repository.searchStudentById(id);

        if (student != null) {
            System.out.println("Student is: " + student.getFirstName());
            System.out.println("Student batch: " + student.getBatch());
            System.out.println("Student FirstName:: " + student.getFirstName());
        } else  {
            throw new EntityNotFoundException(
                    "Student with ID " + id + " not found"
            );
        }
    }
    public void deactivateStudent(int id) {
        boolean deactivated=repository.deactivateStudent(id);
        if (deactivated) {
            System.out.println("Student deactivated");
        }else  {
            System.out.println("Student not deactivated");
            throw new EntityNotFoundException(
                    "Student with ID " + id + " not found"
            );
        }

    }

    public ArrayList<Student> viewStudents() {
        return repository.viewStudents();
    }
}
