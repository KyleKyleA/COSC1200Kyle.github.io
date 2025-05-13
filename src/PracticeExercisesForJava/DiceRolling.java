package PracticeExercisesForJava;
import java.util.Random;
import java.util.Scanner;
public class DiceRolling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter the side on the dice: ");
        int sides = input.nextInt();

        //Roll the dice (a random number will generate between numbers 1 through 6)
        int result = rand.nextInt(sides) + 1;

        System.out.println("the number you rolled the dice is: " + result + "!" );

    }
}
