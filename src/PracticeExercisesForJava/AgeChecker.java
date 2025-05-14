package PracticeExercisesForJava;
import java.util.Scanner;
public class AgeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("Your an Adult.");
        }
        else {
            System.out.println("Your a minor.");
        }

    }
}
