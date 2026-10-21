import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupByFirstLetterExercise12 {

    void main() {
        // 1. Given list of names
        var names = List.of("Alice", "Bob", "Anna", "Charlie", "Brian", "Amanda", "Carl");

        // 2. Group names by their first letter
        var groupedNames = new HashMap<Character, List<String>>();

        for (var name : names) {
            if (!name.isEmpty()) {
                var firstLetter = name.charAt(0);
                // computeIfAbsent creates a new ArrayList if the key doesn't exist yet
                groupedNames.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(name);
            }
        }

        // 3. Print each group
        IO.println("--- Group Names by First Letter ---");
        for (var entry : groupedNames.entrySet()) {
            IO.println("Letter '" + entry.getKey() + "': " + entry.getValue());
        }
    }
}