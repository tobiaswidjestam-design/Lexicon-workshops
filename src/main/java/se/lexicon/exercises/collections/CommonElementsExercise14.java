
package se.lexicon.exercises.collections;

import java.util.HashSet;
import java.util.List;

public class CommonElementsExercise14 {

    void main() {
        // 1. Given two lists
        var listA = List.of(1, 3, 5, 7, 9, 11);
        var listB = List.of(3, 6, 9, 12, 15);

        // 2. Find common elements using a HashSet
        var commonElements = new HashSet<>(listA);
        commonElements.retainAll(listB);

        // 3. Print the result
        IO.println("--- Common Elements ---");
        IO.println("List A: " + listA);
        IO.println("List B: " + listB);
        IO.println("Common elements: " + commonElements);
    }
}