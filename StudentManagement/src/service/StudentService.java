package service;

import java.util.ArrayList;

import entity.Student;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    
    
    //To Check if email already exists
    public boolean isEmailExists(String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
    
    

    //To Add student
    public boolean addStudent(Student s) {
        if (isEmailExists(s.getEmail())) {
            return false;
        }
        students.add(s);
        return true;
    }
    
    

    // Search by email
    public Student searchByEmail(String email) {
    	System.out.println(email);
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null;
    }

    // Delete student by id
    public void deleteStudent(String email) {
        Student s = searchByEmail(email);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    
    
    
    
    // get students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }
}
