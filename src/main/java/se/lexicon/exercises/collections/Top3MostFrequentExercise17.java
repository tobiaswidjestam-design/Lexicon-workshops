package se.lexicon.exercises.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Top3MostFrequentExercise17 {

    void main() {
        // 1. Given list of words
        var words = List.of("java", "python", "java", "c++", "python", "java", "ruby", "c++", "python", "ruby", "java");

        // 2. Count word frequencies using a HashMap
        var wordCounts = new HashMap<String, Integer>();
        for (var word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 3. Sort entries by frequency in descending order
        var sortedEntries = new ArrayList<>(wordCounts.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // 4. Print the top 3 most frequently occurring words
        IO.println("--- Top 3 Most Frequent Words ---");
        IO.println("All frequencies: " + wordCounts);
        IO.println("Top 3 words:");

        var limit = Math.min(3, sortedEntries.size());
        for (var i = 0; i < limit; i++) {
            var entry = sortedEntries.get(i);
            IO.println((i + 1) + ". " + entry.getKey() + " (" + entry.getValue() + " times)");
        }
    }
}