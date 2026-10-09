package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ArithmeticOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter first number: ");
        int num1 = Integer.parseInt(reader.readLine());

        System.out.print("Enter second number: ");
        int num2 = Integer.parseInt(reader.readLine());

        // Beräkna och skriv ut de fyra räknesätten
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }
}
