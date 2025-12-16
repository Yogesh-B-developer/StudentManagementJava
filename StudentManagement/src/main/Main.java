package main;

import entity.Course;
import entity.Enrollment;
import entity.Student;
import service.InputUtil;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        
        int choice;

        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Register For Course");
            System.out.println("6. See the course you have registered");
            System.out.println("7. To Exit Application");
            System.out.print("Enter choice: ");

            choice = InputUtil.scanner.nextInt();
            InputUtil.scanner.nextLine();
            switch (choice) {
            case 1:
                String email;
                while (true) {
                    System.out.print("Enter Email: ");
                    email = InputUtil.scanner.nextLine().trim();

                    if (email.isEmpty()) {
                        System.out.println("Email cannot be empty.");
                        continue;
                    }
                    if(!(InputUtil.validEmail(email))) {
                    	System.out.println("Email is not valid");
                    	continue;
                    }

                    if (service.isEmailExists(email)) {
                        System.out.println("Email already exists. Enter a different email.");
                    } else {
                        break;
                    }
                }
                String name;
                
                while(true) {

                System.out.print("Enter Name: ");
                name = InputUtil.scanner.nextLine().trim();
                if(!InputUtil.validName(name)) {
                	System.out.println("name cannot be less than 2 characters"
                			+ " and should not contain any special characters or numbers");
                	continue;
                }
                else break;
                }

                System.out.print("Enter Age: ");
                int age = InputUtil.scanner.nextInt();
                InputUtil.scanner.nextLine(); // ✅ consume newline

                Student s = new Student(email, name, age);
                service.addStudent(s);
                System.out.println("Student added successfully.");
                break;



                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter email ID to search: ");
                    String searchId = InputUtil.scanner.nextLine().trim();
                    Student found = service.searchByEmail(searchId);
                    System.out.println(found != null ? found : "Student not found");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = InputUtil.scanner.nextLine();
                    service.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Register for a course");
                    System.out.print("Enter Email: ");
                    String emailForEnrollment = InputUtil.scanner.nextLine().trim();

                    if (!InputUtil.validEmail(emailForEnrollment)) {
                        System.out.println("Invalid email format.");
                        break;
                    }

                    if (!service.isEmailExists(emailForEnrollment)) {
                        System.out.println("Email does not exist. Please register first.");
                        break;
                    }

                    Student foundStudent = service.searchByEmail(emailForEnrollment);

                    System.out.print("Enter J/j for Java or N/n for NodeJs: ");
                    char c = InputUtil.scanner.next().charAt(0);
                    InputUtil.scanner.nextLine();

                    c = Character.toLowerCase(c);
                    String course;

                    if (c == 'j') {
                        course = "Java";
                    } else if (c == 'n') {
                        course = "NodeJs";
                    } else {
                        System.out.println("Invalid course choice.");
                        break;
                    }

                    Enrollment enrollment = new Enrollment(foundStudent, course);

                 Course.registerCourse(foundStudent.getEmail(), course);

                 System.out.println("Enrollment successful: " + enrollment);

                    break;
                    
                case 6:
                    System.out.println("Do you want to know the courses that you have enrolled for select y/n");
                    char x = InputUtil.scanner.next().charAt(0);
                    InputUtil.scanner.nextLine();

                    if (x == 'y') {
                        Course course2 = new Course();
                        System.out.print("Enter your mail: ");
                        String emailRegistered = InputUtil.scanner.nextLine();
                        String result = Course.findRegisteredStudent(emailRegistered);

                        if (result == null) {
                            System.out.println("You have entered wrong email");
                        } else {
                            System.out.println("The course you hae registered is:"+result);
                        }
                    } else if (x == 'n') {
                        break;
                    } else {
                        System.out.println("Invalid Selection");
                    }
                    break; 


                case 7:
                	System.out.println("Exiting application...");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }
}
