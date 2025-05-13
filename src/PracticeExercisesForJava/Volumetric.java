
package PracticeExercisesForJava;
import java.util.Scanner;
public class Volumetric {
    public static void main(String[] args) {
        final double KIDDLE_VOLUME = 0.06;
        final double SMALL_VOLUME = 0.12;
        final double MEDIUM_VOLUME = 1.2;
        final double LARGE_VOLUME = 3.6;

        Scanner input = new Scanner(System.in);

        //Prompt for user input
        System.out.println("Please enter the number od kiddie cones sold this week:");
        double KiddleQuantity = input.nextDouble();

        System.out.println("Please enter the number of small kiddle cones sold this week:");
        double SmallQuantity = input.nextDouble();

        System.out.println("Please enter the number of medium kiddle cones sold this week");
        double MediumQuantity = input.nextDouble();

        System.out.println("please enter the number of large kiddle cones sold this week");
        double LargeQuantity = input.nextDouble();

        double sales_quantity = (KiddleQuantity * KIDDLE_VOLUME +
                SmallQuantity * SMALL_VOLUME +
                MediumQuantity * MEDIUM_VOLUME +
                LargeQuantity * LARGE_VOLUME);

        //round up to the first decimal point
        sales_quantity = Math.round(sales_quantity * 10.0) / 10.0;

        //Output
        System.out.println("Total volume of ice cream sold this week:" + sales_quantity + "liter");
        //Pause to let the user view the output
        System.out.println("please enter to close the program");
        input.nextLine();
        input.nextLine();
        System.out.println("Have a nice day");

        input.close();

    }
}
