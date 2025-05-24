package PracticeExercisesForJava;
import java.util.Scanner;
public class AgeInYears {
    public static void main(String[] args) {
        final int AGE_IN_DAYS = 7900;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter person's age:  ");
        int ageInDays = input.nextInt();

        int years =  ageInDays / 365;
        int daysleft = ageInDays % 365;

        System.out.println("Age in days is: " + ageInDays);
        System.out.println("That is appromixetly" + years + "years and " + daysleft + "days.");



    }
}
