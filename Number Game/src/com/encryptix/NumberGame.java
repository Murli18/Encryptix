package com.encryptix;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int MAX_ROUNDS = 4;
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Start Game : Guess Random Number");
        System.out.println("Guess the number between " + LOWER_LIMIT + " and " + UPPER_LIMIT + ".");
        System.out.println("You have total " + MAX_ATTEMPTS + " attempts per round.");
        System.out.println("You have total " + MAX_ROUNDS + " rounds in this game");
        
        while (roundsPlayed < MAX_ROUNDS) {
            System.out.println("\nRound " + (roundsPlayed + 1) + " begins!");
            if (playRound(scanner)) {
                roundsWon++;
            }
            roundsPlayed++;
            System.out.println("Congratulation! YOU have won Total Rounds till now : " + roundsWon);
            
            if (roundsPlayed < MAX_ROUNDS) {
            
                System.out.print("Do you want to play the next round? (Yes/No): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Total Rounds Won: " + roundsWon);
        scanner.close();
    }

    private static boolean playRound(Scanner scanner) {
        Random random = new Random();
        int exactnumber = random.nextInt(UPPER_LIMIT - LOWER_LIMIT + 1) + LOWER_LIMIT;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (" + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == exactnumber) {
                System.out.println("Correct! You've guessed the right number.");
                return true;
            } else if (userGuess < exactnumber) {
                System.out.println("Low!");
            } else {
                System.out.println("High!");
            }
        }
        System.out.println("You've used all your attempts. The correct number was: " + exactnumber);
        return false;
    }
}
