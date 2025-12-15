package service;

import java.util.Scanner;

public class InputUtil {
    public static Scanner scanner = new Scanner(System.in);
    
    public static boolean validEmail(String email) {
    	
    	String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        	
    	return email.matches(emailRegex);
    }
    
    public static boolean validName(String name) {
    	String nameRegex = "^[A-Za-z ]{2,}$";
        return name.matches(nameRegex);
    }
}
