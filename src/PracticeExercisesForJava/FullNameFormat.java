package PracticeExercisesForJava;

import java.util.Scanner;

public class FullNameFormat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String firstName = input.nextLine();

        System.out.println("Please enter your last name");
        String lastname = input.nextLine();

        String fullName = firstName + " " + lastname;

        System.out.println("Hello, " + fullName + "!");
    }
}
