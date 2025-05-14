package PracticeExercisesForJava;
import java.util.Scanner;
public class DayOfTheWeek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number from 1-7: ");
        int number = input.nextInt();

        if (number == 1) {
            System.out.println("Sunday is the 7th day of the week");
        }
        else if (number == 2) {
            System.out.println("Monday is the 1st day of the week");
        }
        else if (number == 3) {
            System.out.println("Tuesday is the second day of the week");
        }
        else if (number == 4) {
            System.out.println("Wednesday is the third day of the week");
        }
        else if (number == 5) {
            System.out.println("Thursday is the fourth day of the week");
        }
        else if (number == 6) {
            System.out.println("Friday is the fifth day of the week");
        }
        else if (number == 7) {
            System.out.println("Saturday is the sixth day of the week");
        }
        else {
            System.out.println("Invalid number. Please try again.");
        }

    }
}
