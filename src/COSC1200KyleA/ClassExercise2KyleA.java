/*ClassExercise2KyleA.java
*Name: Kyle Angeles
*Date 5/27/25
*Write an application that collects the daily morning temperature for the first four (4)
* months of the year and reports the temperatures, the monthly average and the average for the semester.
* Testing an application that collects so much data from the user can be onerous so let's generate the data using Math.Random
* and an algorithm so that the numbers are in a suitable range specified by the user. */
package COSC1200KyleA;
/*Packages that we are going to be using for the program*/
import java.util.Scanner;
import java.util.Random;
public class ClassExercise2KyleA {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April"}; //We be using this year's calendar
        int[] DaysInMonth = {31, 28, 31, 30}; //Array for the days in our 2025 calendar from each month
        
        //Initial prompts for the user to enter values
        Scanner input = new Scanner(System.in);
        System.out.println("Enter minimum temperature: ");
        double minimumTemp = input.nextDouble();

        System.out.println("Enter maximum temperature: ");
        double maximumTemp = input.nextDouble();


        Random rand = new Random(); //Using random import
        double semester_total = 0;
        int total_days = 0;

        for (int i = 0; i < months.length; i++) {
            String month = months[i];
            int days = DaysInMonth[i];
            double monthlyTotal = 0;

            System.out.println("\n " + month + "Temperature");


            for (int day = 1; day <= days; day++) {
                double temps = minimumTemp + (maximumTemp - minimumTemp) * rand.nextDouble();
                //temps = Math.random(temps * 10.0) / 10;
                // USing this math imported function rounds it up to 1.0 Decimal
                /* This prints our the day + the temps during each month */
                System.out.println("Day " + day + ":" + temps + "C°");

                monthlyTotal += temps;
            }

            double SemesterAvg = monthlyTotal / days;
            SemesterAvg = Math.round(SemesterAvg * 100.0) / 100.0;

            //Output for Semester Average Temperatures
            System.out.println("\nSemester Average Temperatures: " + SemesterAvg + "C°");

            semester_total += monthlyTotal;
            total_days += days;


        }

        }

    }

