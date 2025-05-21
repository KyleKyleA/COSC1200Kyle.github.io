/*ClassExercise1KyleA.java
* #Name: Kyle Angeles
* #Date 5/14/25
 */
package COSC1200KyleA;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
    // the Calculation formula for this assignment Weight (lb) / height (in) ^2 ( 703
    public static void main(String[] args) {
        String status = "";
        String answer = "Yes";

        //Using import scanner for user input
        Scanner input = new Scanner(System.in);

        //D along with prompts
        System.out.println("Enter weight in (lbs): ");
        double weight = input.nextDouble();

        System.out.println("Enter height in (in's): ");
        double height = input.nextDouble();
        input.close();

        System.out.println(weight);
        System.out.println(height);

        double bmi = (weight / (height * weight)) * 703;

        DecimalFormat df = new DecimalFormat("0.0");
        String bmiFormatted = df.format(bmi);



        if (bmi < 16) {
            status = "severly underweight";
        }else if (bmi > 16 && bmi < 18) {
            status = "underweight";
        }else if (bmi > 18 && bmi < 25) {
            status = "healthy";
        }else if  (bmi > 25 && bmi < 30) {
            status = "OverWeight";
        }else if (bmi  == 30 || bmi > 30) {
            status = "obese";
        }

        //This displays an output
        System.out.println("\n BMI Calculations ");
        System.out.println("Height: " + height + "Inchies ");
        System.out.println("Weight: " + weight + "Pounds");
        System.out.println("Your BMI is: " + bmiFormatted);
        System.out.println("Your are classified as: " + status);


        input.nextLine();
        System.out.println("\nWould you like to calculate your BMI again? (Yes or no");
        answer = input.nextLine().trim().toLowerCase();

    }
}
