package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public void enrollStudent(Enrollment enrollment) {
        try {
            enrollmentRepository.enrollStudent(enrollment);
            System.out.println("Enrollment added successfully");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error in adding enrollment " + e.getMessage());
        }
    }

    public List<Enrollment> viewEnrollments() {
        return enrollmentRepository.viewEnrollments();
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {
        boolean updateStatus = enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
        if (updateStatus) {
            System.out.println("Enrollment Status Updated");
        } else {
            System.out.println("Enrollment Status Not Updated");
            throw new EntityNotFoundException(
                    "Enrollment with ID " + enrollmentId + " not found"
            );
        }
    }
}
