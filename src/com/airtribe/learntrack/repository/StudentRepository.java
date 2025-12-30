
package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public ArrayList<Student> viewStudents() {
        return studentList;
    }

    public Student searchStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean deactivateStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setActive(false);
                return true;
            }
        }
        return false;
    }
}