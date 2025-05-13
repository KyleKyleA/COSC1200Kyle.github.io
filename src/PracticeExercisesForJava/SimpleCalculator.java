package PracticeExercisesForJava;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        double num1 = input.nextDouble();

        System.out.println("Please enter an operator(+, -, *, /): ");
        char operator = input.next().charAt(0);  // Read the first char

        System.out.println("Enter a second number: ");
        double num2 = input.nextDouble();

        double result;

        if (operator == '+') {
            result = num1 + num2;
        }
        else if
            (operator == '-') {
                result = num1 - num2;
        }
        else if (operator == '*') {
            result = num1 * num2;
        }
        else if (operator == '/') {
            result = num1 / num2;
        }else{
            System.out.println("Operator is invalid :( ");
           return;
        }
        System.out.println("results is: " + result);


    }


}

