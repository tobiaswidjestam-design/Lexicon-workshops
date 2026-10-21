package se.lexicon.exercises.collections;

import java.util.HashSet;
import java.util.List;

public class TwoSumExercise15 {

    void main() {
        // 1. Given list of integers and target number
        var numbers = List.of(2, 7, 11, 15, 4, 6);
        var target = 13;

        // 2. Find two numbers that add up to the target without nested loops
        var seenNumbers = new HashSet<Integer>();
        Integer num1 = null;
        Integer num2 = null;

        for (var number : numbers) {
            var complement = target - number;

            if (seenNumbers.contains(complement)) {
                num1 = complement;
                num2 = number;
                break;
            }
            seenNumbers.add(number);
        }

        // 3. Print the result
        IO.println("--- Two Sum ---");
        IO.println("Numbers: " + numbers);
        IO.println("Target: " + target);
        if (num1 != null && num2 != null) {
            IO.println("Found pair: " + num1 + " + " + num2 + " = " + target);
        } else {
            IO.println("No such pair found.");
        }
    }
}