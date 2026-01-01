import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                try {
                    System.out.println(AppConstants.STUDENT_MENU_HEADER);
                    System.out.println("1 Add Student");
                    System.out.println("2 View Students");
                    System.out.println("3 Search Student");
                    System.out.println("4 Deactivate Student");

                    System.out.println(AppConstants.COURSE_MENU_HEADER);
                    System.out.println("5 Add Course");
                    System.out.println("6 View Courses");
                    System.out.println("7 Activate/Deactivate Course");

                    System.out.println(AppConstants.ENROLLMENT_MENU_HEADER);
                    System.out.println("8 Enroll Student");
                    System.out.println("9 View Enrollments");
                    System.out.println("10 Update Enrollment");

                    System.out.println("11 Exit");

                    int choice = InputValidator.readInt("Enter your choice");
                    InputValidator.validateRange(choice, 1, 11);

                    switch (choice) {
                        case MenuOptions.ADD_STUDENT -> addStudentMain();
                        case MenuOptions.VIEW_STUDENT -> viewStudentsMain();
                        case MenuOptions.SEARCH_STUDENT -> searchStudentMain();
                        case MenuOptions.DEACTIVATE_STUDENT -> deactivateStudentMain();

                        case MenuOptions.ADD_COURSE -> addNewCourseMain();
                        case MenuOptions.VIEW_COURSE -> viewCoursesMain();
                        case MenuOptions.TOGGLE_COURSE -> activateDeactivateCourseMain();

                        case MenuOptions.ENROLL_STUDENT -> enrollStudentMain();
                        case MenuOptions.VIEW_ENROLLMENTS -> viewEnrollmentsMain();
                        case MenuOptions.UPDATE_ENROLLMENT -> markEnrollmentsMain();

                        case MenuOptions.EXIT -> {
                            System.out.println(AppConstants.EXIT_MESSAGE);
                            System.exit(0);
                        }
                        default -> throw new InvalidInputException(
                                AppConstants.INVALID_MENU_OPTION
                        );
                    }

                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            input.next(); // clear buffer
        }

    }

    public static void viewStudentsMain() {
        System.out.println("All Students List:");
        //studentService.viewStudents();
        for (Student s : studentService.viewStudents()) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getFirstName())
                    .append(" ")
                    .append(s.getLastName())
                    .append(" of id ")
                    .append(s.getId());

            System.out.println(sb.toString());
        }
    }

    public static void searchStudentMain() {
        System.out.println("Enter Student ID");
        Scanner input = new Scanner(System.in);
        studentService.searchStudentById(input.nextInt());
    }

    public static void deactivateStudentMain() {
        System.out.println("Enter Student ID to deactivate");
        Scanner input = new Scanner(System.in);
        studentService.deactivateStudent(input.nextInt());
    }

    public static void addStudentMain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String studentName = input.next();
        System.out.println("Enter Student Surname");
        String studentSurname = input.next();
        System.out.println("Enter Student Email");
        String studentEmail = input.next();
        System.out.println("Enter Student batch");
        String studentBatch = input.next();
        int studentId = IdGenerator.getNextStudentId();
        boolean sStatus = true;
        Student student = new Student(studentId, studentName, studentSurname, studentEmail, studentBatch, sStatus);
        studentService.addStudent(student);
    }

    public static void addNewCourseMain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Name");
        String courseName = input.next();
        System.out.println("Enter Course Description");
        String courseDesc = input.next();
        System.out.println("Enter Course Duration In Weeks");
        int courseDurationInWeeks = input.nextInt();
        int courseId = IdGenerator.getNextCourseId();
        boolean cStatus = true;
        Course course = new Course(courseId, courseName, courseDesc, courseDurationInWeeks, cStatus);
        courseService.addCourse(course);
    }

    public static void viewCoursesMain() {
        System.out.println("All Courses List:");
        for (Course c : courseService.viewCourses()) {
            System.out.println(String.format("%s %s ::Duration:: %s of CourseId: %d", c.getCourseName(), c.getDescription(), c.getDurationInWeeks(), c.getId()));
        }
    }

    public static void activateDeactivateCourseMain() {
        System.out.println("Enter Course ID to deactivate");
        Scanner input = new Scanner(System.in);
        courseService.deactivateCourse(input.nextInt());
    }

    public static void enrollStudentMain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Enrollment ID");
        int enrollmentId = input.nextInt();
        System.out.println("Enter Student ID");
        int studentId = input.nextInt();
        System.out.println("Enter Course ID");
        int courseId = input.nextInt();
        if (!courseService.isCourseValidService(courseId)) {
            throw new InvalidInputException("Course does not exist or is inactive:Enrollment Failed");
        }
        System.out.println("Enter Enrollment Date");
        LocalDate enrollmentDate = LocalDate.parse(input.next());
        EnrollmentStatus enrollmentStatus = EnrollmentStatus.ACTIVE;
        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, enrollmentDate, enrollmentStatus);
        enrollmentService.enrollStudent(enrollment);
    }

    public static void viewEnrollmentsMain() {
        System.out.println("All Enrollments List:");
        for (Enrollment e : enrollmentService.viewEnrollments()) {
            System.out.println(String.format("Enrollment Id: %d :: Enrollment CourseId: %d :: Enrollment Date: %s :: Enrollment Status: %s", e.getId(), e.getCourseId(), e.getEnrollmentDate(), e.getStatus()));
        }
    }

    public static void markEnrollmentsMain() {
        System.out.println("Enter Enrollment ID to deactivate");
        Scanner input = new Scanner(System.in);
        int enrollmentId = input.nextInt();
        EnrollmentStatus status = getEnrollStatus();
        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        // courseService.markEnrollment(input.nextInt());
    }

    public static EnrollmentStatus getEnrollStatus() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Status:");
        System.out.println("12 ACTIVE");
        System.out.println("13 COMPLETED");
        System.out.println("14 CANCELLED");

        int choice = input.nextInt();
        return switch (choice) {
            case 12 -> EnrollmentStatus.ACTIVE;
            case 13 -> EnrollmentStatus.COMPLETED;
            case 14 -> EnrollmentStatus.CANCELLED;
            default -> throw new InvalidInputException("Invalid status option");
        };
    }
}
