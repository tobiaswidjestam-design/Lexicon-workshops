package se.lexicon.exercises.exceptions;
import java.util.Scanner;


// Basic Exception Handling try catch

public class Exercise1 {

    void main() {
        Scanner input = new Scanner(System.in);


        try {
            IO.print("Enter the first integer A: ");
            int a = input.nextInt();

            IO.print("Enter the second integer B: ");
            int b = input.nextInt();

            int check = a / b;
            double result = (double) a / b;
            System.out.println("The Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: It is not possible to divide " + e.getMessage());
        }


    }
}