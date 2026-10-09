package se.lexicon.exercises.exercise1;

public class FizzBuzz {
    public static void main(String[] args) {
        // Loop through integers from 1 to 30
        for (int i = 1; i <= 30; i++) {
            // Check for both 3 and 5 first
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
