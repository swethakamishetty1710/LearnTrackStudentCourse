package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter=1;
    private static int courseIdCounter=100;
    private static int enrollmentDateCounter;
    public static int getNextStudentId(){
        studentIdCounter++;
        return studentIdCounter;
    }
    public static int getNextCourseId(){
        courseIdCounter++;
        return courseIdCounter;
    }
}
