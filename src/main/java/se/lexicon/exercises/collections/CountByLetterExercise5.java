import java.util.List;
import java.util.Scanner;

public class CountByLetterExercise5 {

    void main() {
        // 1. Given list of names
        var names = List.of("Anna", "Bob", "Alice", "Charlie", "Amanda", "David", "Amy", "Brian");

        // 2. Ask the user to enter a letter
        var scanner = new Scanner(System.in);
        IO.println("--- Count Names by Letter ---");
        IO.println("Enter a letter to check:");
        var input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            IO.println("Please enter a valid letter.");
            return;
        }

        // Convert target letter to lowercase for case-insensitive comparison
        var targetChar = Character.toLowerCase(input.charAt(0));

        // 3. Count how many names start with that letter
        var count = 0;
        for (var name : names) {
            if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == targetChar) {
                count++;
            }
        }

        // 4. Print the result
        IO.println("Number of names starting with '" + input.charAt(0) + "': " + count);
    }
}