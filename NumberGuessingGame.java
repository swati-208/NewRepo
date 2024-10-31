package Taskintern;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1; // Lower bound for the guessing range
        int upperBound = 100; // Upper bound for the guessing range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate random number
        int userGuess = 0;
        int attempts = 0;
        int maxAttempts = 10; // Set the maximum number of attempts

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        // Game loop
        while (userGuess != numberToGuess && attempts < maxAttempts) {
            try {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number within the range!");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }

                // Check if the maximum attempts have been reached
                if (attempts >= maxAttempts && userGuess != numberToGuess) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + numberToGuess);
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

