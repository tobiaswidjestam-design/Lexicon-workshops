package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GradeCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter score: ");
        int score = Integer.parseInt(reader.readLine());

        // Check if score is within valid range (0 to 100)
        if (score < 0 || score > 100) {
            System.out.println("Error: Score must be between 0 and 100.");
        } else if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
