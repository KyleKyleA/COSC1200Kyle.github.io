package PracticeExercisesForJava;
import java.util.Scanner;
public class UserNameAge {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the user's name: ");
        String name = input.nextLine();

        System.out.println("Please enter the user's age: ");
        int age = input.nextInt();

        System.out.println("My name is " + name + " and I am" + age + " years old ");

    }
}
