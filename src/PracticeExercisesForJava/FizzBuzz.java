package PracticeExercisesForJava;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(9);
        fizzBuzz(25);
        fizzBuzz(15);
        fizzBuzz(4);
    }

    public static void fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println ("FizzBuzz");
        }
        else if (i % 3 == 0) {
            System.out.println("Buzz");
        }
        else if (i % 5 == 0) {
            System.out.println("Fizz");
        }
        else {
            System.out.println(i);
        }
    }
}
