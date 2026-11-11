package se.lexicon.exercises.Functional_Programming;

@FunctionalInterface
public interface PersonRule {
    // Evaluates a specific rule against a person
    boolean test(Person person);
}