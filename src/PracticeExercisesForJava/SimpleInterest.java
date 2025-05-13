package PracticeExercisesForJava;
import java.util.Scanner;
public class SimpleInterest {
    public static void main (String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pleas enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.println("please enter the interest rate: (e.g decimal form such as 0.5 or 4.5%");
        double rate = input.nextDouble();

        System.out.println("Please enter the time in years: (e.g 5 years or 1 year  ");
        double time = input.nextDouble();

        double interest = principal * rate * time;

        System.out.println("Simple interest rate be: $" + interest);

    }

}
