package se.lexicon.exercises.collections;

import java.util.LinkedHashSet;
import java.util.List;

public class MergeWithoutDuplicatesExercise8 {

    void main() {
        // 1. Given two lists
        var listA = List.of(1, 2, 3, 4, 5);
        var listB = List.of(3, 4, 5, 6, 7);

        // 2. Merge them into a single collection with no duplicates
        var mergedCollection = new LinkedHashSet<>(listA);
        mergedCollection.addAll(listB);

        // 3. Print the result and the total count
        IO.println("--- Merge Without Duplicates ---");
        IO.println("List A: " + listA);
        IO.println("List B: " + listB);
        IO.println("Merged collection: " + mergedCollection);
        IO.println("Total count: " + mergedCollection.size());
    }
}