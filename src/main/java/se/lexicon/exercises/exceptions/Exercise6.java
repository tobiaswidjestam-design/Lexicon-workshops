package se.lexicon.exercises.exceptions;

import java.util.Scanner;

/**
 * Exercise 6: Throwing Exceptions
 *
 * Task:
 * Write a method that takes a string as input and checks if it is a valid email address.
 * If the input is invalid, throw an IllegalArgumentException with an appropriate message.
 *
 * Hint:
 * Use the throw keyword to manually throw the exception.
 */
public class Exercise6 {

    void main() {
        Scanner scanner = new Scanner(System.in);
        IO.print("Enter an email address to validate: ");
        String input = scanner.nextLine().trim();

        if (!input.isEmpty()) {
            try {
                validateEmail(input);
                IO.println("Success: '" + input + "' is a valid email address.");
            } catch (IllegalArgumentException e) {
                IO.println("Validation Error: " + e.getMessage());
            }
        } else {
            IO.println("No input provided. Running demonstration tests:\n");
            testEmail("john.doe@example.com");
            testEmail("alexander@lexicon.se");
            testEmail("invalid-email");
            testEmail("user@domain");
            testEmail("user@.com");
            testEmail("");
        }
    }

    /**
     * Validates an email address.
     *
     * @param email the email string to validate
     * @throws IllegalArgumentException if the email is null, blank, or improperly formatted
     */
    public static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email address cannot be null or empty.");
        }

        // Email format: username @ domain . top-level-domain
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format: '" + email + "'. Expected format: user@domain.com");
        }
    }

    private static void testEmail(String email) {
        try {
            validateEmail(email);
            IO.println("VALID   -> " + email);
        } catch (IllegalArgumentException e) {
            IO.println("INVALID -> \"" + email + "\" | Reason: " + e.getMessage());
        }
    }
}
