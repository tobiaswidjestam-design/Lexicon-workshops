package se.lexicon.exercises.collections;

import java.util.List;
import java.util.TreeMap;

public class WordFrequencyExercise6 {

    void main() {
        // 1. Given list of words
        var words = List.of("apple", "banana", "apple", "orange", "banana", "apple", "grape", "orange");

        // 2. Count how many times each word appears using a TreeMap for automatic alphabetical sorting
        var wordCountMap = new TreeMap<String, Integer>();

        for (var word : words) {
            // getOrDefault returns the current count or 0 if the word is not yet in the map
            var currentCount = wordCountMap.getOrDefault(word, 0);
            wordCountMap.put(word, currentCount + 1);
        }

        // 3. Print each word and its count
        IO.println("--- Word Frequency (Alphabetical Order) ---");
        for (var entry : wordCountMap.entrySet()) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}