package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private CourseRepository courseRepository = new CourseRepository();

    public void addCourse(Course course) {
        try {
            if (course == null) {
                throw new IllegalArgumentException("Course cannot be null");
            }
            courseRepository.addCourse(course);
            System.out.println("Course added successfully");
        } catch (Exception e) {
            System.out.println("Error in adding course" + e.getMessage());
        }

    }

    public List<Course> viewCourses() {
        return courseRepository.viewCourses();
    }

    public void deactivateCourse(int courseID) {
        boolean cDeactivated = courseRepository.deactivateCourse(courseID);
        if (!cDeactivated) {
            throw new EntityNotFoundException(
                    "Course with courseID " + courseID + " not found"
            );
        }
    }

    public boolean isCourseValidService(int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        return course != null && course.isActive();
    }

}
