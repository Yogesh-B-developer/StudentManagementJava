package entity;


public class GraduateStudent extends Student {

    private String specialization;

    public GraduateStudent(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Graduate Student");
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialization: " + specialization;
    }
}
