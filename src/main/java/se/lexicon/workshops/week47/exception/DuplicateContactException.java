package se.lexicon.workshops.week47.exception;

public class DuplicateContactException extends RuntimeException {
    public DuplicateContactException(String message) {
        super(message);
    }
}
