package se.lexicon.exercises.exercise2;

public class StringStats {


    void main() {

        String sentence = IO.readln("Enter sentence: ");

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        // Convert to lowercase to make vowel/consonant checks easier
        String lower = sentence.toLowerCase();

        // 2. Loop through every character in the string
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            }
        }

        // 4. Print the summary
        IO.println("Vowels    : " + vowels);
        IO.println("Consonants: " + consonants);
        IO.println("Digits    : " + digits);
        IO.println("Spaces    : " + spaces);

    }
}


