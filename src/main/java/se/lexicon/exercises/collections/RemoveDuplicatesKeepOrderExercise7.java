import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicatesKeepOrderExercise7 {

    void main() {
        // 1. Given list of numbers with duplicates
        var numbers = List.of(4, 7, 2, 7, 9, 4, 1, 9, 3);

        // 2. Produce a new list/collection with duplicates removed, preserving the original order
        var uniqueNumbers = new LinkedHashSet<>(numbers);

        // 3. Print the result
        IO.println("--- Remove Duplicates (Keep Order) ---");
        IO.println("Original list: " + numbers);
        IO.println("Without duplicates: " + uniqueNumbers);
    }
}