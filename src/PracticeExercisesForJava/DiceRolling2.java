package PracticeExercisesForJava;

import java.util.Random;
import java.util.Scanner;

public class DiceRolling2 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Please enter the side on the dice: ");
        int sides = input.nextInt();

        if (sides < 2) {
            System.out.println("Error the dice must have two sides.. ");
        } else {

            int result = rand.nextInt(sides) + 1;

            System.out.println("the number you rolled the dice is: " + result + "!");

            //Optional give a special message for high or lows rolls
            if (result == sides) {
                System.out.println("Wow! you have rolled the highest possible number");
            } else if (result == 1) {
                System.out.println("Wow you have rolled the lowest possible number in this game ");
            } else {
                System.out.println("Nice roll! ");
            }
        }
    }
}
