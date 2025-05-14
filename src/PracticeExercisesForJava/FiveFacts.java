package PracticeExercisesForJava;
import java.util.Scanner;
public class FiveFacts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?: ");
        String name = input.nextLine();

        System.out.println("What is your favorite food: ");
        String food = input.nextLine();

        System.out.println("What is your hobby: ");
        String hobby = input.nextLine();

        System.out.println("What is your pet's name?: ");
        String petName = input.nextLine();

        System.out.println("What is your dream job in the future: ");
        String dreamJob = input.nextLine();

        System.out.println();
        System.out.println("Hi! My name is " + name + ".");
        System.out.println(" I love eating " + food + ".");
        System.out.println(" in my free time  i enjoy " + hobby + ".");
        System.out.println(" have a pet named " + petName + ".");
        System.out.println(" and one day I hope to become a " + dreamJob + "!");
    }
}
