package PracticeExercisesForJava;
import java.util.Scanner;
public class AverageBetween3Nums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first number: ");
        double a = input.nextDouble();

        System.out.println("Please enter the second number: ");
        double b = input.nextDouble();

        System.out.println("Please enter the third number: ");
        double c = input.nextDouble();

        double average = (a + b + c) / 3.0;

        System.out.println("The average between " + "3 nums is: " + average);

    }
}
