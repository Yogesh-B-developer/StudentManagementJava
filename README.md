# StudentManagement

**Features** :
              1. Add new students with validation
              2. View all students
              3. Search student by email
              4. Delete student by email
              5. Register a student for a course (Java / NodeJs)
              6. View the course a student is enrolled in
              7. Input validation for email and name

**Important Notes** 
                   Emails are unique identifiers for students
                   Email must be registered before enrolling in a course
                   Course enrollment is stored in memory (not persistent)
                   Data resets when the program exits


**Class Overview**
        **Student**:
                     Represents a student
                     Fields: email, name, age

  **StudentService**:
                     Manages student operations
                     Add, view, search, delete students
      **Enrollment**:
                     Represents a student’s enrollment in a course
                     Links a Student to a course name

  **Course**:
            Manages all course registrations
            Uses a static HashMap<String, String> to store:              
  **InputUtil**:
             Provides input validation methods
             Validates email and name
