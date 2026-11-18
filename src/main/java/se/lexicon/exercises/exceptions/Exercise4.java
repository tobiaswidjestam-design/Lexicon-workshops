package se.lexicon.exercises.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Exercise 4: Nested try-catch Blocks
 *
 * Task:
 * Write a program that attempts to read a file and parse its contents as integers.
 *
 * Implement nested try-catch blocks to handle:
 * - NoSuchFileException (Outer catch)
 * - IOException (Outer catch)
 * - NumberFormatException (Inner catch)
 */
public class Exercise4 {

    void main() {
        Scanner scanner = new Scanner(System.in);
        IO.print("Enter the path to the file (e.g. 'numbers.txt'): ");
        String filePath = scanner.nextLine().trim();

        if (filePath.isEmpty()) {
            filePath = "numbers.txt";
            IO.println("No path entered. Using default: " + filePath);
        }

        parseIntegersFromFile(filePath);
    }

    public static void parseIntegersFromFile(String filePath) {
        // Outer try-catch block for file-related operations and exceptions
        try {
            Path path = Path.of(filePath);
            List<String> lines = Files.readAllLines(path);

            IO.println("\n--- Successfully opened file: " + path.getFileName() + " ---");
            IO.println("Parsing file contents as integers:\n");

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();

                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // Inner try-catch block for parsing-related exceptions
                try {
                    int number = Integer.parseInt(line);
                    IO.println("Line " + (i + 1) + ": Parsed integer -> " + number);
                } catch (NumberFormatException e) {
                    IO.println("Line " + (i + 1) + ": NumberFormatException -> '" + line + "' is not a valid integer (" + e.getMessage() + ")");
                }
            }

            IO.println("\nFinished reading and processing file.");

        } catch (NoSuchFileException e) {
            IO.println("NoSuchFileException: The file could not be found -> " + e.getFile());
        } catch (IOException e) {
            IO.println("IOException: An error occurred while reading the file -> " + e.getMessage());
        }
    }
}
