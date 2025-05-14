package PracticeExercisesForJava;
import java.util.Scanner;
public class GradeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a grade(0-100): ");
        int grade = input.nextInt();

        if ( grade >= 90 && grade <= 100 ) {
            System.out.println(" You got an A,Wow excellent job!!.");
        }
        else if (grade >= 80) {
            System.out.println("Still got an AStill a pretty great job.");
        }
        else if (grade >= 70) {
            System.out.println("You got a B, still pretty good but try a bit harder next time.");
        }
        else if (grade >= 60) {
            System.out.println("You got a C, pretty average but encourage to do better next time.");
        }
        else if (grade >= 50) {
            System.out.println("You got a D, at least you passed but i want you to spend more time studying.");
        }
        else if (grade >= 0 ) {
            System.out.println("You got an F, spend more time asking for help in the future.");
        }
        else {
            System.out.println("Invalid grade input, Please put a number.");
        }


    }
}
