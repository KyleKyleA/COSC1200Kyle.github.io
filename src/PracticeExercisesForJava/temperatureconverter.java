package PracticeExercisesForJava;

import java.util.Scanner;

public class temperatureconverter {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double fahrenheit;
        double celsius;

        System.out.println("Enter Fahrenheit temperature: ");
        fahrenheit = input.nextDouble();

        celsius = (fahrenheit - 32) * 5 / 9;

        System.out.println(fahrenheit + "° Fahrenheit is " + String.format("%.1f", celsius) + "° Celsius.");
        System.out.println();

        System.out.println("Enter temperature in celsius");
        celsius = input.nextDouble();
        fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + "° Celsius is " + String.format("%.1f", fahrenheit) + "° Fahrenheit");
        input.close();
    }
}
