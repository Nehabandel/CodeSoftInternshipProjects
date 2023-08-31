package com.codesoft.task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalNumberOfRoundPlayed = 0;
		int totalNumberOfWonRound = 0;
		int totalNumberOfRoundLost = 0;
		while (true) {
			boolean playedRounds = playNumberGameRepeat(scanner);
			totalNumberOfRoundPlayed++;
			if (playedRounds) {
				totalNumberOfWonRound++;
			}
			else {
				totalNumberOfRoundLost++;
			}
			System.out.print("Do you want to play another round? (yes/no): ");
			String playAgain = scanner.next();
			if (!playAgain.equalsIgnoreCase("yes")) {
				break;
			}
		}
		System.out.println("Thanks for playing number game");
		System.out.println(
				"You have played " + totalNumberOfRoundPlayed + " out of won " + totalNumberOfWonRound + " game" + " and Lost " + totalNumberOfRoundLost + " game!!");

		scanner.close();
	}

	private static boolean playNumberGameRepeat(Scanner scanner) {
		// Random number generation
		Random random = new Random();
		int initialValue = 1;
		int finalValue = 100;
		boolean guessed = false;
		int randomNumber = random.nextInt(finalValue - initialValue + 1) + initialValue;
		// Guess generated random number

		int attempts = 0;
		int maxAttempts = 5;
		while (attempts < maxAttempts) {
			System.out.print("Guess the number between " + initialValue + " and " + finalValue + ": ");
			int userGuess = scanner.nextInt();
			if (userGuess < initialValue || userGuess > finalValue) {
				attempts += 1;
				System.out.println("Please guess a number within the specified range.");
			} else if (userGuess < randomNumber) {
				attempts += 1;
				System.out.println("Too low. Try again.");
			} else if (userGuess > randomNumber) {
				attempts += 1;
				System.out.println("Too high. Try again.");
			} else {
				attempts += 1;
				System.out.println(
						"Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
				guessed = true;
				return true;
			}
		}
		if (!guessed && attempts >= maxAttempts) {
			System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
					+ randomNumber + ".");
		}
		return false;
	}
}
