package PracticeExercisesForJava;
import java.util.Scanner;
public class NumberComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your number: ");
        int num1 = input.nextInt();

        System.out.println("Please enter number: ");
        int num2 = input.nextInt();

        if (num1 > num2) {
            System.out.println("The first number is greater than second number");
        } else if (num2 > num1) {
            System.out.println("the second number is greater than the first number");
        } else {
            System.out.println("Both numbers are equal");
        }
    }
}
