package se.lexicon.exercises.exercise2;

public class InitialsGenerator {

    void main() {

        // Prompt the user to input their full name (first, optional middle, and last name)
        String fullName = IO.readln("Enter Full Name: ");
        // 2. Split the full name into words based on spaces
        String[] words = fullName.trim().split("\\s+");

        StringBuilder initials = new StringBuilder();
        // 3. Loop through each word and extract the first letter
        for (String word : words) {
            // Iterate through each word extracted from the full name array
            if (!word.isEmpty()) {
                // Check that the current word is not empty to prevent index out of bounds errors
                char initial = Character.toUpperCase(word.charAt(0));
                // Extract the first character (index 0) of the word and convert it to uppercase
                initials.append(initial).append(".");
                // Append the uppercase initial letter followed by a dot (.) to our StringBuilder
            }
        }

        IO.println("Initials: " + initials);

    }

}