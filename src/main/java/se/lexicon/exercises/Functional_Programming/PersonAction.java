package se.lexicon.exercises.Functional_Programming;

@FunctionalInterface
public interface PersonAction {
    // Executes an action on a given person
    void execute(Person person);
}