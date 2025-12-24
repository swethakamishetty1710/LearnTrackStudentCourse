# LearnTrack – Student & Course Management System 

## Project Description
LearnTrack is a **console-based Student, Course, and Enrollment Management System**
built using **Core Java**.

The application allows administrators to:
- Manage students (add, view, search, deactivate)
- Manage courses (add, view, activate/deactivate)
- Manage enrollments (enroll students, view enrollments, update enrollment status)

This project focuses on **Java fundamentals** such as:
- Core Java syntax
- Object-Oriented Programming (OOP)
- Collections (ArrayList)
- Exception handling
- Menu-driven console applications
- Clean code and layered design

All data is stored **in memory** using collections (no database).

---

## Features

### Student Management
- Add new student
- View all students
- Search student by ID
- Deactivate a student

### Course Management
- Add new course
- View all courses
- Activate / Deactivate course

### Enrollment Management
- Enroll a student into a course
- View enrollments for a student
- Mark enrollment as ACTIVE / COMPLETED / CANCELLED

---

```md
## Project Structure

com.airtribe.learntrack
│
├── constants
│ ├── MenuOptions.java
│ └── AppConstants.java
│
├── enums
│ ├── EnrollmentStatus
│
├── entity
│ ├── Person.java
│ ├── Student.java
│ ├── Course.java
│ ├── Enrollment.java
│ └── EnrollmentStatus.java
│
├── repository
│ ├── StudentRepository.java
│ ├── CourseRepository.java
│ └── EnrollmentRepository.java
│
├── service
│ ├── StudentService.java
│ ├── CourseService.java
│ └── EnrollmentService.java
│
├── util
│ ├── IdGenerator.java
│ └── InputValidator.java

│
├── exception
│ ├── EntityNotFoundException.java
│ └── InvalidInputException.java
│
│ └── Main.java
│
└── docs
└── Design_Notes.md
---
```
## How to Compile and Run

### Prerequisites
- JDK 8 or above
- Java installed and configured - jdk-25.0.1

### Compile (Using Terminal)
- javac com/airtribe/learntrack/Main.java

### Run Using IDE
- Open project in IntelliJ / Eclipse
- Navigate to Main.java
- Right-click → Run

## Class Diagram

```mermaid
classDiagram
    Person <|-- Student

    Student "1" --> "0..*" Enrollment
    Course "1" --> "0..*" Enrollment

    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getDisplayName()
    }

    class Student {
        -String batch
        -boolean active
    }

    class Course {
        -int id
        -String courseName
        -String description
        -String durationInWeeks
        -boolean active
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -String enrollmentDate
        -EnrollmentStatus status
    }

    class StudentService
    class CourseService
    class EnrollmentService

    class StudentRepository
    class CourseRepository
    class EnrollmentRepository

    StudentService --> StudentRepository
    CourseService --> CourseRepository
    EnrollmentService --> EnrollmentRepository
