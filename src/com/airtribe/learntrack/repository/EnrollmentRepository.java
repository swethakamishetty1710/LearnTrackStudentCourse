package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.util.ArrayList;

public class EnrollmentRepository {
    ArrayList<Enrollment> enrollments=new ArrayList<>();
    public void enrollStudent(Enrollment enrollment){
        enrollments.add(enrollment);
    }
    public ArrayList<Enrollment> viewEnrollments(){
        return enrollments;
    }
    public boolean updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status){
        for(Enrollment enrollment:enrollments){
            if(enrollmentId==enrollment.getId()){
                enrollment.setStatus(status);
                return true;
            }
        }return false;
    }
}
