package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TimeConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter seconds: ");
        int totalSeconds = Integer.parseInt(reader.readLine());

        // Calculate hours, minutes and remaining seconds
        int hours = totalSeconds / 3600;
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        // Print in HH:MM:SS format with leading zeros (%02d)
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }
}
