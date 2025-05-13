package PracticeExercisesForJava;

import java.util.Scanner;

public class LightSpeedCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the time in seconds: ");
        double time = input.nextDouble();

        double speed_of_light = 299_792_458;

        double distanceMeters = speed_of_light * time;
        double distanceKilometers = distanceMeters / 1000;
        System.out.println("In " + time + "seconds, light travels" + distanceMeters + "meters");
        System.out.println(distanceMeters + "Meters");
        System.out.println(distanceKilometers + "Kilometers");
    }
}
