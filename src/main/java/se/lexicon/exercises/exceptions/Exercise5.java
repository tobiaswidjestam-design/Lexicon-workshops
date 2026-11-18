package se.lexicon.exercises.exceptions;

import java.util.Scanner;

/**
 * Exercise 5: finally Block
 *
 * Task:
 * Modify the program from Exercise 1 to include a finally block that always executes.
 *
 * Hint:
 * The finally block should print a message to the console and execute whether an exception occurs or not.
 */
public class Exercise5 {

    void main() {
        Scanner input = new Scanner(System.in);

        try {
            IO.print("Enter the first integer A: ");
            int a = input.nextInt();

            IO.print("Enter the second integer B: ");
            int b = input.nextInt();

            int check = a / b; // Integer division throws ArithmeticException if b == 0
            double result = (double) a / b;
            IO.println("The Result: " + result);

        } catch (ArithmeticException e) {
            IO.println("Error: It is not possible to divide: " + e.getMessage());
        } finally {
            IO.println("Finally block: This block always executes, regardless of whether an exception occurred.");
            input.close();
        }
    }
}
