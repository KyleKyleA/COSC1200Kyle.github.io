package ObjectOrientProgramming1;
import java.util.Scanner;

public class Magic8Ball {
    public static void main(String[] args) {

        showDescription();
        Scanner input = new Scanner(System.in);

        String question;
        int answer;
        System.out.println("What's on your mind or thinking of right now friend?: ");
        question = input.nextLine();
        answer = (int) (Math.random() * 8) + 1;
        if (answer == 1) {
            System.out.println("It is certain");
        } else if (answer == 2) {
            System.out.println("Without a doubt");
        } else if (answer == 3) {
            System.out.println("You may rely on it");
        }
        if (answer == 4) {
            System.out.println("Ask again later");
        }
        if (answer == 5) {
            System.out.println("Cannot predict now");
        }
        if (answer == 6) {
            System.out.println("Don't count on it ");
        } else if (answer == 7) {
            System.out.println("My sources say no");
        } else if (answer == 8) {
            System.out.println("Outlook not so good");
        }


    }

    private static void showDescription() {
        System.out.println("Welcome to Magic 8 ball ");
    }

}

