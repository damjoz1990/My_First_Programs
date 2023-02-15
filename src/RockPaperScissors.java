/**
 * This program implements a rock paper scissors game between two players.
 * The player inputs their choice of rock, paper, or scissors and the program will
 * output the result of who won the game.
 */

import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};

        // Get player 1's choice
        System.out.print("Player 1, enter your choice (rock/paper/scissors): ");
        String player1Choice = scanner.nextLine().toLowerCase();
        while (!isValidChoice(player1Choice, choices)) {
            System.out.print("Invalid choice. Please enter rock, paper, or scissors: ");
            player1Choice = scanner.nextLine().toLowerCase();
        }

        // Get player 2's choice
        System.out.print("Player 2, enter your choice (rock/paper/scissors): ");
        String player2Choice = scanner.nextLine().toLowerCase();
        while (!isValidChoice(player2Choice, choices)) {
            System.out.print("Invalid choice. Please enter rock, paper, or scissors: ");
            player2Choice = scanner.nextLine().toLowerCase();
        }

        // Determine the winner
        if (player1Choice.equals(player2Choice)) {
            System.out.println("It's a tie!");
        } else if ((player1Choice.equals("rock") && player2Choice.equals("scissors"))
                || (player1Choice.equals("paper") && player2Choice.equals("rock"))
                || (player1Choice.equals("scissors") && player2Choice.equals("paper"))) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    private static boolean isValidChoice(String choice, String[] choices) {
        for (String c : choices) {
            if (c.equals(choice)) {
                return true;
            }
        }
        return false;
    }
}

