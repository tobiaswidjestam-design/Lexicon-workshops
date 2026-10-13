package se.lexicon.exercises.exercise2;

public class PowerTable {

    void main() {
        // 1. Prompt the user to enter a base number
        double base = Double.parseDouble(IO.readln("Enter base: "));

        // 2. Loop from 1 to 10 to calculate and print the powers
        for (int i = 1; i <= 10; i++) {
            // Calculate the power using Math.pow
            double result = Math.pow(base, i);

            // 3. Print the formatted result matching the example layout
            IO.println(String.format("%.0f ^ %-2d = %10.1f", base, i, result));
        }
    }
}




