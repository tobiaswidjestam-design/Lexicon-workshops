
import java.util.HashMap;
import java.util.List;

public class MostFrequentWordExercise13 {

    void main() {
        // 1. Given list of words
        var words = List.of("cat", "dog", "cat", "bird", "dog", "cat", "fish", "dog", "dog");

        // 2. Count how many times each word appears using a HashMap
        var wordCounts = new HashMap<String, Integer>();

        for (var word : words) {
            var currentCount = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, currentCount + 1);
        }

        // 3. Find the word that appears most often
        String mostFrequentWord = null;
        var maxCount = -1;

        for (var entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        // 4. Print the result
        IO.println("--- Most Frequent Word ---");
        IO.println("All word counts: " + wordCounts);
        IO.println("Most frequent word: '" + mostFrequentWord + "' (appears " + maxCount + " times)");
    }
}