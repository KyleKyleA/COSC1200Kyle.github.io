package PracticeExercisesForJava;
import java.util.Scanner;
public class FullNameFormatter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the person's first name");
        String FirstName = input.nextLine();

        System.out.println("Enter the person's last name");
        String LastName = input.nextLine();

        System.out.println("\nFull name" + FirstName + ", "+LastName);
        System.out.println("Last " + LastName + ", " + FirstName);
    }
}
