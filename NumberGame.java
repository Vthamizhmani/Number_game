package batchA;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	 public static void main(String[] args) {
	        
		 Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = 10;
	        int score = 0;

	        System.out.println("Welcome to the Guess the Number game!");

	        boolean continuePlaying = true;

	        while (continuePlaying) {
	            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            int attempts = 0;

	            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");

	            while (attempts < maxAttempts) {
	                System.out.print("Enter your guess: ");
	                int userGuess;

	                try {
	                    userGuess = Integer.parseInt(scanner.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter a number.");
	                    continue;
	                }

	                attempts++;

	                if (userGuess == secretNumber) {
	                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
	                    score++;
	                    break;
	                } else if (userGuess < secretNumber) {
	                    System.out.println("Too low. Try again.");
	                } else {
	                    System.out.println("Too high. Try again.");
	                }
	            }

	            if (attempts == maxAttempts) {
	                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgain = scanner.nextLine();

	            continuePlaying = playAgain.equalsIgnoreCase("yes");
	        }

	        System.out.println("Thanks for playing! Your score is " + score + " rounds won.");
	 }
}
	










