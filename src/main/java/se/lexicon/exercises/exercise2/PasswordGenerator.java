package se.lexicon.exercises.exercise2;

public class PasswordGenerator {

    void main() {
        // 1. Prompt the user for the desired password length
        int length = Integer.parseInt(IO.readln("Enter password length: "));

        // 2. Define the character pool (lowercase, uppercase, and digits)
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // 3. Use StringBuilder to efficiently build the password
        StringBuilder password = new StringBuilder();

        // 4. Loop to randomly select characters up to the desired length
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }

        // 5. Print the generated password
        IO.println("Generated password: " + password);
    }
}



