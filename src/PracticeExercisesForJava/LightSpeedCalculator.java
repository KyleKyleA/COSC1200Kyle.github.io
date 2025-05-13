package PracticeExercisesForJava;

import java.util.Scanner;

public class LightSpeedCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the time in seconds: ");
        double time = input.nextDouble();

        double speed_of_light = 299_792_458;

        double distance = speed_of_light * time;

        System.out.println("In " + time + "seconds, light travels" + distance + "meters");
    }
}
