package se.lexicon.exercises.exercise1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        // Generate a random number between 1 and 500
        int targetNumber = random.nextInt(500) + 1;
        int guess = 0;
        int guessCount = 0;

        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");
            guess = Integer.parseInt(reader.readLine());
            guessCount++; // Increment the number of guesses for each attempt

            if (guess > targetNumber) {
                System.out.println("Too big!");
            } else if (guess < targetNumber) {
                System.out.println("Too small!");
            } else {
                System.out.println("Correct! You got it in " + guessCount + " guesses.");
            }
        }
    }
}
