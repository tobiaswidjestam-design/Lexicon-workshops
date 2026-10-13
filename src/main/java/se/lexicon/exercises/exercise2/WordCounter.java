package se.lexicon.exercises.exercise2;

public class WordCounter {

    void main() {
        // 1. Prompt the user to enter a sentence and the word to search for
        String sentence = IO.readln("Enter a sentence  : ");
        String searchWord = IO.readln("Enter word to find: ");

        // 2. Trim whitespace and split the sentence into words based on spaces
        String[] words = sentence.trim().split("\\s+");

        // Handle empty input edge case: if empty, total words is 0
        int totalWords = sentence.trim().isEmpty() ? 0 : words.length;
        int count = 0;

        // 3. Loop through the words array and count matches case-insensitively
        for (String w : words) {
            if (w.equalsIgnoreCase(searchWord)) {
                count++;
            }
        }

        // 4. Print the summary results
        IO.println("Total words : " + totalWords);
        IO.println("\"" + searchWord + "\" appears: " + count + " times");
    }
}


