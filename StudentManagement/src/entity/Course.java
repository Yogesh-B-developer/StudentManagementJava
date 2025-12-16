package entity;

import java.util.HashMap;
import java.util.Map;

public class Course {

    
    private static Map<String, String> courseEnrolled = new HashMap<>();

    // To Register a course for a student
    public static void registerCourse(String email, String courseName) {
        courseEnrolled.put(email.toLowerCase(), courseName);
    }

    // To Find registered course by email
    public static String findRegisteredStudent(String email) {
        return courseEnrolled.get(email.toLowerCase());
    }
}

