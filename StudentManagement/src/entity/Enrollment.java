package entity;

public class Enrollment {

    private Student student;
    private String courseName;

    public Enrollment(Student student, String courseName) {
        this.student = student;
        this.courseName = courseName;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return student.getEmail() + " enrolled in " + courseName;
    }
}

