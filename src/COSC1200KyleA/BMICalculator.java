/*ClassExercise1KyleA.java
* #Name: Kyle Angeles
* #Date 5/14/25
* Create a Java application that will calculate the body mass index (BMI)
*  of a person as well as a related description of their body mass index.
*  This application should accept a numeric height in inches value in the
* range of 24 to 120 inclusive, and a numeric weight in pounds value
*  with a minimum of 25 pounds. When either of these values is entered
*  in an invalid format or the acceptable range, display an appropriate
*  error message then prompt the user for that value again.
 */
package COSC1200KyleA;
//Two libraries that importing for this assignment
import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
    // the Calculation formula for this assignment Weight (lb) / height (in) ^2 ( 703
    public static void main(String[] args) {
        String status;

        //Using import scanner for user input
        Scanner input = new Scanner(System.in);

        //D along with prompts
        System.out.println("Enter weight in (lbs): ");
        double weight = 0;
        if (input.hasNextDouble()) {
            weight = input.nextDouble();
        }

        //Prompt to enter your height in inches
        if (25 <= weight) {
            System.out.print("Enter height in inches (between 24 and 120): ");
            if (input.hasNextDouble()) {
                double height = input.nextDouble();


                if (height >= 24 && height <= 120) {
                    // Correct BMI formula: weight / (height^2) * 703
                    double bmi = (weight / (height * height)) * 703;
                    DecimalFormat df = new DecimalFormat("0.0");
                    String bmiFormatted = df.format(bmi);


                    //If statements to determine the category
                    //your bmi level you are on
                    if (bmi < 16) {
                        status = "severally underweight";
                    } else if (bmi < 18.5) {
                        status = "underweight";
                    } else if (bmi < 25) {
                        status = "healthy";
                    } else if (bmi < 30) {
                        status = "OverWeight";
                    } else {
                        status = "obese";
                    }

                    //This displays an output
                    System.out.println("\n BMI Calculations ");
                    System.out.println("Height: " + height + "In's ");
                    System.out.println("Weight: " + weight + " Pounds");
                    System.out.println("Your BMI is: " + bmiFormatted);
                    System.out.println("Your BMI category is classified as: " + status);

                    //Suggesting weight change to reach healthy range
                    double minHealthyWeight = 18.5 * height * height / 703;
                    double maxHealthyWeight = 24.9 * height * height / 703;

                    //This piece of code reports a suggested weight loss or gain to be considered healthy
                    if (bmi < 18.5) {
                        double neededGain = minHealthyWeight - weight;
                        System.out.printf("To be considered healthy, you should gain approximately %.1f pounds.%n", neededGain);
                    } else if (bmi > 24.9) {
                        double neededLoss = weight - maxHealthyWeight;
                        System.out.printf("To be considered healthy, you should lose approximately %.1f pounds.%n", neededLoss);
                    } else {
                        System.out.println("You are within the healthy weight range. Keep it up!");
                    }


                    //Making a yes or no continuation system
                    input.nextLine();
                    System.out.println("\nWould you like to calculate your BMI again? (Yes or no");
                    String answer = input.nextLine().trim().toLowerCase();

                    //Prompt to make it rerun the program either saying yes or no
                    if (answer.equals("Yes") || answer.equals("y")) {
                        System.out.println("Please re-run the program to calculate again.");
                    } else {
                        System.out.println("Thank you for using BMI Calculator :) ");
                    }
                } else {
                    System.out.println("Error: Height must be between 24 and 120 inches.");
                }
            } else {
                System.out.println("Error: Please enter a numeric value for height.");
            }
        } else {
            System.out.println("Error: Weight must be at least 25 pounds.");
            System.out.println("Error: Please enter a numeric value for weight.");
        }
    }
}
