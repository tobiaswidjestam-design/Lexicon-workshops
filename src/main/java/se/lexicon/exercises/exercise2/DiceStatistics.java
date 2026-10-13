package se.lexicon.exercises.exercise2;
import java.util.Random;


public class DiceStatistics {

    void main() {
        // 1. Prompt the user for how many times to roll the dice
        int rolls = Integer.parseInt(IO.readln("How many rolls? "));

        Random random = new Random();
        int doubleCount = 0;

        // 2. Loop through the specified number of rolls
        for (int i = 1; i <= rolls; i++) {
            // Roll two six-sided dice (generates numbers from 1 to 6)
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;

            // 3. Check if both dice show the same value (a double)
            boolean isDouble = (die1 == die2);
            if (isDouble) {
                doubleCount++;
            }

            // 4. Print the individual roll result
            String output = String.format("Roll %d: %d + %d = %d", i, die1, die2, sum);
            if (isDouble) {
                output += "  DOUBLE!";
            }
            IO.println(output);
        }

        // 5. Print the final summary of doubles rolled
        IO.println("Doubles rolled: " + doubleCount + " out of " + rolls);
    }
}









