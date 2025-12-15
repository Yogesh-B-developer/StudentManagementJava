package entity;


public class Student extends Person {

    private String email;
    private int age;

    public static String collegeName = "AirTripe University";

    public Student(String email, String name, int age) {
        super(name,email);
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Name: " + name + ", Age: " + age;
    }
}

