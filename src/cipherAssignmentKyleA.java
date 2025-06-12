/*
 * #Name: Kyle Angeles
 * #Date 6/2/25
 * #Description - This program will implement an encryption\decryption cipher. After selecting the mode (encrypt or decrypt)
 * the user will enter a phrase to be acted upon followed by the cipher selection and complexity key or shift value.
 * The program will then present the result of the operation
 * and ask if the user wants to repeat the process or exit the program.
 */

/*region LIBRARIES used for this program*/
import java.util.Scanner;
/*endregion LIBRARIES*/

public class cipherAssignmentKyleA {
    //Declarations of arrays
     static String ENGALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
     static String COSCALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean runAgain = true;

        while (runAgain) {
            //Declarations
            //Initialize variables
            displayDescription();

            String phrase = getPhrase();
            int cipherChoice = getCipherChoice();
            int complexity = getComplexity();
            String result;
            //Endregion GLOBAL VARIABLES
            //Ciphers choice when entered
            if (cipherChoice == 1) {
                int shift = getShift();
                result = translationCipher(phrase, shift, complexity);
            } else {
                result = substitutionCipher(phrase, complexity,ENGALPHABET, COSCALPHABET );
            }
            //Result or output of the program
            //asks the user if they want to run it again.
            displayMessage(phrase, result);
            runAgain = askRunAgain();
        }

        System.out.println("Goodbye!");
    }

    /*region methods*/
    /*This method just shows the displayed description for this program*/
    public static void displayDescription() {
        System.out.println("Welcome to cipher program " +
                "addition using a new method called the sub method");
    }

    public static String getPhrase() {
        //Initialize Variables
        Scanner input = new Scanner(System.in);
        String phrase;

        /*iterates through each line of code until the user enters only letters*/
        while (true) {
            System.out.print("\nEnter a sentence (letters only, no spaces): ");
            phrase = input.nextLine().trim();

            if (phrase.matches("[A-Za-z]+")) {
                return phrase;
            } else {
                /*Error message if it's anything other than letters*/
                System.out.println("Invalid input. Only letters without spaces or digits are allowed.");
            }
        }
    }

    public static int getCipherChoice() {
        int type = 0;
        String userInput;
        Scanner input = new Scanner(System.in);

        while (type != 1 && type != 2) {
            /*Greets the user and provides a prompt*/
            System.out.print("Choose a cipher:\n1 - Translation\n2 - Substitution\nChoice: ");
            userInput = input.nextLine();
            if (userInput.equals("1") || userInput.equals("2")) {
                type = Integer.parseInt(userInput);
            } else {
                System.out.println("Invalid input. Enter 1 or 2.");
            }
        }

        return type;
    }


    public static int getShift() {
        Scanner input = new Scanner(System.in);
        String userInput;
        int shift = 0;

        while (shift < 1 || shift > 25) {
            System.out.println("Enter a shift amount between the numbers of (1-25): ");
            userInput = input.nextLine();
            if (userInput.matches("\\d+")) {
                shift = Integer.parseInt(userInput);
                if (shift < 1 || shift > 25) {
                    System.out.println("Enter a Shift amount between (1-25)");

                }
            } else {
                System.out.println("Invalid input. Enter a number from 1 to 25.");
            }
        }
        return shift;
    }

    public static int getComplexity() {
        int complex = 0;
        String userInput;
        Scanner input = new Scanner(System.in);

        while (complex < 1 || complex > 10) {

            System.out.println("Enter complexity (number of reptition, (1-10): ");
            userInput = input.nextLine();
            if (userInput.matches("\\d+")) {
                complex = Integer.parseInt(userInput);
                if (complex < 1 || complex > 10) {
                    System.out.println("This is incorrect input, of number of repetition please try again.");
                }
            } else {
                System.out.println("Invalid input. PLease enter a positive number");

            }
        }
        return complex;
    }

    public static String translationCipher(String text, int shift, int complexity) {
        String result = text;

        for (int i = 0; i < complexity; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : result.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    sb.append((char) ('A' + (ch - 'A' + shift) % 26));
                } else if (Character.isLowerCase(ch)) {
                    sb.append('a' + (ch - 'a' + shift) % 26);
                } else {
                    sb.append(ch);
                }

            }
            result = sb.toString();
        }
        return result;
    }


    public static String substitutionCipher(String text, int complexity, String ENG_ALPHABET, String COSC_ALPHABET) {
        String result = text;

        for (int i = 0; i < complexity; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : result.toCharArray()) {
                int index = ENG_ALPHABET.indexOf(ch);
                if (index != -1) {
                    sb.append(COSC_ALPHABET.charAt(index));
                } else {
                    sb.append(ch); // again, for safety
                }
            }
            result = sb.toString();
        }
        return result;
    }

    public static void displayMessage(String origin, String ciphered) {
        System.out.println("\norigin: " + origin);
        System.out.println("\nCiphered: " + ciphered);

    }
    /*Outputs the Origin of the word and the ciphered word as a string*/

    public static boolean askRunAgain() {
        Scanner input = new Scanner(System.in);
        String response;

        while (true) {
            /*While loop to run the program if the user intends too*/
            System.out.print("Would you like to run the program again? (yes or no): ");
            response = input.nextLine().trim().toLowerCase();

            if (response.equals("yes")) return true;
            if (response.equals("no")) return false;

            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            /*endregion methods*/
        }
    }
}
















