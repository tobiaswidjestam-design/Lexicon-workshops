package se.lexicon.exercises.exercise1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GreetUser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter first name: ");
        String firstName = reader.readLine();

        System.out.print("Enter last name: ");
        String lastName = reader.readLine();

        System.out.println("Hello, " + firstName + " " + lastName + "! Welcome aboard.");
    }
}
