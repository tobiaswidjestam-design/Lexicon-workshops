package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AverageOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter first number: ");
        int num1 = Integer.parseInt(reader.readLine());

        System.out.print("Enter second number: ");
        int num2 = Integer.parseInt(reader.readLine());

        System.out.print("Enter third number: ");
        int num3 = Integer.parseInt(reader.readLine());

        // Cast sum to double so that division preserves the decimal part
        double average = (double) (num1 + num2 + num3) / 3;

        System.out.println("Average: " + average);
    }
}
