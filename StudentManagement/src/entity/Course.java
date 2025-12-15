package entity;

import java.util.HashMap;
import java.util.Map;

public class Course {

    // Shared storage for all enrollments
    private static Map<String, String> courseEnrolled = new HashMap<>();

    // Register a course for a student
    public static void registerCourse(String email, String courseName) {
        courseEnrolled.put(email.toLowerCase(), courseName);
    }

    // Find registered course by email
    public static String findRegisteredStudent(String email) {
        return courseEnrolled.get(email.toLowerCase());
    }
}
