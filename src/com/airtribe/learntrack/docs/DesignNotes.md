# Design Notes – LearnTrack Project

## 1. Why ArrayList Instead of Array?

ArrayList was chosen instead of arrays because:
- The number of students, courses, and enrollments is dynamic
- ArrayList automatically resizes as elements are added or removed
- It provides useful methods like add(), remove(), and iteration
- It simplifies code compared to manually managing array sizes
- Arrays are fixed-size and are not suitable for dynamic data management in this project.

## 2. Use of Static Members

- Static members were used in the following places:
### IdGenerator
- Static counters for Student, Course, and Enrollment IDs
- Ensures unique IDs across the application
- Avoids creating multiple generator objects

### 3. Use of Inheritance
Person → Student
Common attributes like id, firstName, lastName, and email are placed in the Person class

Student extends Person and adds student-specific fields such as batch and active status

### Benefits gained
- Code reuse
- Cleaner class design
- Easier maintenance
- Clear representation of real-world relationships
- Inheritance helped avoid duplication and improved readability.

### 4. Layered Architecture
- The project follows a layered structure:
- UI (Main): Handles input/output and menus
- Service: Contains business logic and validations
- Repository: Manages in-memory data storage
- Entity: Represents domain objects
- This separation of concerns improves maintainability and scalability.

### 5. Exception Handling
- Custom exceptions were introduced to: 
    - Handle invalid user input
    - Handle missing entities like Student or Course
    - Exceptions are thrown in the Service layer and handled in the UI layer to prevent application crashes and provide user-friendly messages.