import java.util.List;

public class FindLargestExercise4 {

    void main() {
        // 1. Given list of numbers
        var numbers = List.of(14, 3, 78, 45, 22, 91, 7, 56);

        // 2. Find the largest number using a loop
        var largest = numbers.get(0);
        for (var number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }

        // 3. Print the result
        IO.println("--- Find the Largest Number ---");
        IO.println("Numbers: " + numbers);
        IO.println("The largest number is: " + largest);
    }
}