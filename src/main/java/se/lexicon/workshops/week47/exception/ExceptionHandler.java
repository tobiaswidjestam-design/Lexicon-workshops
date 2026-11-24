package se.lexicon.workshops.week47.exception;

public class ExceptionHandler {
    public void handle(Exception e) {
        switch (e) {
            case DuplicateContactException duplicateContactException -> System.err.println("Duplicate contact: " + e.getMessage());
            case ContactStorageException contactStorageException -> System.err.println("Storage error: " + e.getMessage());
            case IllegalArgumentException illegalArgumentException -> System.err.println("Invalid input: " + e.getMessage());
            default -> System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
