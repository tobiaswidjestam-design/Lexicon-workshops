package se.lexicon.exercises.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 7: Custom Exceptions for List Operations
 *
 * Task:
 * Create a program that manages a list of names.
 *
 * Implement:
 * - A method to find a name in the list
 *   - Throw NameNotFoundException if the name is not found
 * - A method to add a name to the list
 *   - Throw DuplicateNameException if the name already exists
 */
public class Exercise7 {

    void main() {
        NameManager nameManager = new NameManager();

        IO.println("=== Exercise 7: Name Manager with Custom Exceptions ===\n");

        // 1. Adding names to the list
        try {
            nameManager.addName("Anna");
            nameManager.addName("Erik");
            nameManager.addName("Maria");
            IO.println("Current list of names: " + nameManager.getNames());
        } catch (DuplicateNameException e) {
            IO.println("Error adding name: " + e.getMessage());
        }

        // 2. Attempting to add a duplicate name -> triggers DuplicateNameException
        IO.println("\n--- Test: Adding duplicate name 'Anna' ---");
        try {
            nameManager.addName("Anna");
        } catch (DuplicateNameException e) {
            IO.println("Caught DuplicateNameException: " + e.getMessage());
        }

        // 3. Finding an existing name in the list -> successful lookup
        IO.println("\n--- Test: Finding existing name 'Erik' ---");
        try {
            String foundName = nameManager.findName("Erik");
            IO.println("Found name: " + foundName);
        } catch (NameNotFoundException e) {
            IO.println("Caught NameNotFoundException: " + e.getMessage());
        }

        // 4. Finding a non-existing name -> triggers NameNotFoundException
        IO.println("\n--- Test: Finding non-existing name 'Johan' ---");
        try {
            String foundName = nameManager.findName("Johan");
            IO.println("Found name: " + foundName);
        } catch (NameNotFoundException e) {
            IO.println("Caught NameNotFoundException: " + e.getMessage());
        }

        IO.println("\nFinal list of names: " + nameManager.getNames());
    }
}

/**
 * Manages a list of names and enforces uniqueness and search validation.
 */
class NameManager {
    private final List<String> names = new ArrayList<>();

    /**
     * Adds a name to the list.
     *
     * @param name the name to add
     * @throws DuplicateNameException if the name already exists in the list
     */
    public void addName(String name) throws DuplicateNameException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        for (String existing : names) {
            if (existing.equalsIgnoreCase(name.trim())) {
                throw new DuplicateNameException("The name '" + name + "' already exists in the list.");
            }
        }

        names.add(name.trim());
        IO.println("Successfully added: " + name.trim());
    }

    /**
     * Finds a name in the list.
     *
     * @param name the name to search for
     * @return the found name
     * @throws NameNotFoundException if the name is not present in the list
     */
    public String findName(String name) throws NameNotFoundException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Search name cannot be null or empty.");
        }

        for (String existing : names) {
            if (existing.equalsIgnoreCase(name.trim())) {
                return existing;
            }
        }

        throw new NameNotFoundException("The name '" + name + "' was not found in the list.");
    }

    /**
     * Returns an unmodifiable view of the names list.
     */
    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}

/**
 * Custom checked exception thrown when attempting to add a name that already exists.
 */
class DuplicateNameException extends Exception {
    public DuplicateNameException(String message) {
        super(message);
    }
}

/**
 * Custom checked exception thrown when a searched name is not found in the list.
 */
class NameNotFoundException extends Exception {
    public NameNotFoundException(String message) {
        super(message);
    }
}
