package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;

public class CourseRepository {
private ArrayList<Course> courseList=new ArrayList<Course>();
public void addCourse(Course course) {
    courseList.add(course);
}
public ArrayList<Course> viewCourses()
{
    return courseList;
}
public boolean deactivateCourse(int courseID){
    for (Course course : courseList) {
        if (course.getId() == courseID) {
            course.setActive(false);
            return true;
        }
    }
    return false;
}

}
