package se.lexicon.exercises.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Exercise 8: Try-with-Resources
 *
 * Task:
 * Create a Java application that writes a string of text to a file.
 * Use the try-with-resources statement to ensure resources are automatically closed
 * after the operation is complete.
 *
 * Hint:
 * Try-with-resources works with classes that implement AutoCloseable.
 */
public class Exercise8 {

    void main() {
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter file name to write to (default: output.txt): ");
        String filePath = scanner.nextLine().trim();
        if (filePath.isEmpty()) {
            filePath = "output.txt";
            IO.println("Using default file: " + filePath);
        }

        IO.print("Enter text to write (press Enter for default sample text): ");
        String content = scanner.nextLine().trim();
        if (content.isEmpty()) {
            content = "Hello, Lexicon! Java try-with-resources demonstration.";
            IO.println("Using sample text: \"" + content + "\"");
        }

        writeToFile(filePath, content);
        readAndDisplayFile(filePath);
    }

    /**
     * Writes text to a file using try-with-resources.
     * The BufferedWriter and FileWriter implement AutoCloseable and are automatically
     * closed when execution leaves the try block, even if an exception occurs.
     *
     * @param filePath the path to the target file
     * @param content the string content to write
     */
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.newLine();
            IO.println("\n[SUCCESS] Content successfully written to '" + filePath + "'.");
            IO.println("[INFO] Resources automatically closed via try-with-resources.");
        } catch (IOException e) {
            IO.println("[ERROR] Failed to write to file: " + e.getMessage());
        }
    }

    /**
     * Reads and prints the contents of a file using try-with-resources.
     *
     * @param filePath the path to the file to read
     */
    public static void readAndDisplayFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            IO.println("\n--- Verifying File Content (" + filePath + ") ---");
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                IO.println("Line " + lineNumber++ + ": " + line);
            }
        } catch (IOException e) {
            IO.println("[ERROR] Failed to read from file: " + e.getMessage());
        }
    }
}
