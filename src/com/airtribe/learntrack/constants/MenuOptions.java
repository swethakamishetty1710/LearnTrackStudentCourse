package com.airtribe.learntrack.constants;

public class MenuOptions {

    // Student_ADD_STUDENT,VIEW_STUDENT,SEARCH_STUDENT,DEACTIVATE_STUDENT
    public static final int ADD_STUDENT = 1;
    public static final int VIEW_STUDENT = 2;
    public static final int SEARCH_STUDENT = 3;
    public static final int DEACTIVATE_STUDENT = 4;

    // Course ADD_COURSE,VIEW_COURSE,TOGGLE_COURSE
    public static final int ADD_COURSE = 5;
    public static final int VIEW_COURSE = 6;
    public static final int TOGGLE_COURSE = 7;

    // Enrollment ENROLL_STUDENT,VIEW_ENROLLMENTS,UPDATE_ENROLLMENT
    public static final int ENROLL_STUDENT = 8;
    public static final int VIEW_ENROLLMENTS = 9;
    public static final int UPDATE_ENROLLMENT = 10;

    public static final int EXIT = 11;

    private MenuOptions() {
        throw new UnsupportedOperationException(
                "This is a constants class and cannot be instantiated"
        );
    }
}
