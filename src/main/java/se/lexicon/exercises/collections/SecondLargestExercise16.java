package se.lexicon.exercises.collections;

import java.util.List;
import java.util.TreeSet;

public class SecondLargestExercise16 {

    void main() {
        // 1. Given list of numbers
        var numbers = List.of(34, 78, 23, 78, 91, 56, 91, 12);

        // 2. Remove duplicates and sort automatically using a TreeSet
        var uniqueNumbers = new TreeSet<>(numbers);

        // 3. Find the second largest unique value
        if (uniqueNumbers.size() < 2) {
            IO.println("Not enough unique numbers to find a second largest.");
            return;
        }

        // lower() or converting to a list allows us to find elements relative to the highest
        var highest = uniqueNumbers.last();
        var secondLargest = uniqueNumbers.lower(highest);

        // 4. Print the result
        IO.println("--- Second Largest Unique Value ---");
        IO.println("Original list: " + numbers);
        IO.println("Unique sorted values: " + uniqueNumbers);
        IO.println("Second largest unique value: " + secondLargest);
    }
}