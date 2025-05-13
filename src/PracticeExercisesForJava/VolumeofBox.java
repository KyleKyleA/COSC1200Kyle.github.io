package PracticeExercisesForJava;
import java.util.Scanner;
public class VolumeofBox {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PLease enter the length of the box: ");
        double length = input.nextDouble();

        System.out.println("Please enter the width of the box: ");
        double width = input.nextDouble();

        System.out.println("Please enter the height of the box");
        double height = input.nextDouble();

        double volume = length * width * height;

        System.out.println("The volume of the box is: " + volume + "Cubic meters");

    }
}
