package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;

public class CourseService {
    private CourseRepository courseRepository = new CourseRepository();
    public void addCourse(Course course){
        try {
            courseRepository.addCourse(course);
            System.out.println("Course added successfully");
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println("Error in adding course"+e.getMessage());
        }

    }
    public ArrayList<Course> viewCourses(){
        return courseRepository.viewCourses();
    }
    public void deactivateCourse(int courseID){
        boolean cDeactivated=courseRepository.deactivateCourse(courseID);
        if(cDeactivated){
            System.out.println("Course Deactivated");
        }else {
            System.out.println("Course Not Deactivated");
            throw new EntityNotFoundException(
                    "Course with courseID " + courseID + " not found"
            );

        }
    }
}
