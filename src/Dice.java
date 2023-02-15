/**
 * This program runs a dice rolling game.
 * The user presses enter to roll the dice, which generates a random number between 1 and 6.
 * The user then has the option to roll again or not.
 */

import java.util.Random;
import java.util.Scanner;
public class Dice {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();
            int result = random.nextInt(6) + 1;
            System.out.println("You rolled a " + result);

            System.out.println("Roll again? (y/n)");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("n")) {
                playAgain = false;
            }
        }
        scanner.close();
    }
}

