package PracticeExercisesForJava;
import java.util.Scanner;
public class CheckersGame {
    public static void main(String[] args) {
        Integer[][] board = createBoard();
        displayDescription();
        displayBoard(board);

        int row = getRowChoice();
        int col = getColumnChoice();

        int remainingOccupiedSpaces = countOccupiedSpaces(board);
        displayOccupiedSpaces(remainingOccupiedSpaces);
    }

    public static void displayDescription() {
        System.out.println("This program is designed to allow the user to place 4 checkers on a CHECKER BOARD");
    }
    public static Integer[][] createBoard() {
        Integer[][] board = new Integer[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
        return board;
    }
    public static void displayBoard(Integer[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int getRowChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a row number between 0-7");
        return input.nextInt();
    }

    public static int getColumnChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a col number between 0-7");
        return input.nextInt();
    }

    public static void updateBoard(Integer[][] board, int row, int col) {
        board[row][col] = 1;
    }

    public static int countOccupiedSpaces(Integer[][] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void displayOccupiedSpaces(int count) {
        System.out.println("Int the checker board, there are ccurrently " + count + "spaces occupied.");
    }

}
