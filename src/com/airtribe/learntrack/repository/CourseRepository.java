package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courseList = new ArrayList<Course>();

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public List<Course> viewCourses() {
        return courseList;
    }

    public boolean deactivateCourse(int courseID) {
        for (Course course : courseList) {
            if (course == null) {
                continue;
            }
            if (course.getId() == courseID) {
                course.setActive(false);
                return true;
            }
        }
        return false;
    }

    public Course getCourseById(int courseId) {
        for (Course c : courseList) {
            if (c.getId() == courseId) {
                return c;
            }
        }
        return null;
    }
}
