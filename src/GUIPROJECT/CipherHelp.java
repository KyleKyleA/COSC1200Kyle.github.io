package GUIPROJECT;

import java.util.Scanner;

public class CipherHelp extends CryptDecryptGUI{
    static String ENGALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static String COSCALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

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
}
