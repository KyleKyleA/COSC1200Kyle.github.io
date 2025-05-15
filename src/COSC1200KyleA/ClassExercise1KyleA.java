/*ClassExercise1KyleA.java
* #Name: Kyle Angeles
* #Date 5/14/25
* #Description Write a Validation class containing 4 methods (GetValidInteger, GetValidFloat, GetValidDouble, GetValidCharacter)
* which prompts and then forces the user to
*  enter valid data that meets the criteria of both data type and range of values.*/
package COSC1200KyleA;
import java.util.Scanner;
public class ClassExercise1KyleA {

    /*Declarations for each method along with a description for the program*/
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    showDescription();
    int grade = GetValidInteger(0, 100);
    float number = GetValidFloat(-5, 7);
    double price = GetValidDouble(0.0, 100.0);
    char answer = GetValidCharacter("YN");

    //This is just a print statement showing the output after the program has been fully executed
    System.out.println("\nSummary");
    System.out.println("Grade: " + grade);
    System.out.println("Float value: " + number);
    System.out.println("Double value: " + price);
    System.out.println("Countinue?:  " + answer);

    }

    public static void showDescription() {
        System.out.println("Welcome to practice exercise number 1 dealing with creating 4 methods" +
                "to get ValidInteger, ValidFloat, ValidDouble, and ValidCharacter");
    }
    /*First method is to get valid integer between max and min */
    //We use int as value since we're looking for a number
    //then run it through a while loop to make see it excutes right
    //along putting an if and else statement to determine if the data shown meets the critique
    //then we continue doing the same thing for the rest of the methods.
    public static int GetValidInteger(int min, int max) {
        int value;
        while (true) {
            System.out.println("please enter a number between: " + min + "and " + max);
            if (input.hasNextInt()) {
                value = input.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Value out of range. Try again.");
                }
            } else {
                System.out.println("That's not a whole number. Try again.");
            }
        }
    }
    /*Second method is used to get the float value between min and max values */
    public static float GetValidFloat(float min, float max) {
        float value;
        while (true) {
            System.out.println("Please enter a whole number between -5 and 7:" + min + "and " + max);
            if (input.hasNextFloat()) {
                value = input.nextFloat();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Float value is our of range. Please reenter data: ");
                }
            } else {
                System.out.println("That isn't a decimal value.");
            }

        }
    }

    /*This method is to show GetValidDouble between max and min values*/
    public static double GetValidDouble(double min, double max) {
        double value;
        while (true) {
            System.out.println("Please enter a double value between" + min + "and" + max);
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Double value is out of the range barrier, Please try again");
                }
            } else {
                System.out.println("That isn't a double value.");
            }
        }
    }

    /*This method is for getting valid character from allowed options (Y or N) */
    public static char GetValidCharacter(String validOptions) {
        char userInput;
        while (true) {
            System.out.print("Enter one of the following: " + validOptions + " : ");
            String line = input.next();
            if (line.length() == 1) {
                userInput = Character.toUpperCase(line.charAt(0));
                if (validOptions.toUpperCase().contains(String.valueOf(userInput))) {
                    return userInput;
                }
            }
            System.out.println("Invalid character. Try again.");
        }
    }
}


