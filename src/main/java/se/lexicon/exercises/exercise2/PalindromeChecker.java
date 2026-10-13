package se.lexicon.exercises.exercise2;

public class PalindromeChecker {

    void main() {

        // 1. Prompt the user to enter a word
        String word = IO.readln("Enter a word: ");
        // 2. Convert the word to lowercase to ensure case-insensitive comparison
        String normalized = word.toLowerCase();

        // 3. Reverse the normalized string using StringBuilder
        String reversed = new StringBuilder(normalized).reverse().toString();

        // 4. Check if the original normalized word equals the reversed version
        if (normalized.equals(reversed)) {
            IO.println(word + " is a palindrome.");
        } else {
            IO.println(word + " is NOT a palindrome.");
        }
    }
}




