package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> viewEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public boolean updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {
        for (Enrollment enrollment : enrollments) {
            if (enrollmentId == enrollment.getId()) {
                enrollment.setStatus(status);
                return true;
            }
        }
        return false;
    }
}
