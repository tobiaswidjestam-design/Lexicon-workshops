package se.lexicon.exercises.collections;

import java.util.HashSet;
import java.util.List;

public class SubmissionTrackerExercise9 {

    /*
     * Chosen Collection: HashSet
     * Reason:
     * 1. A HashSet automatically rejects duplicate elements, which fits the rule that a student can only submit once.
     * 2. The order of submissions does not matter, and HashSet offers efficient O(1) performance for additions and lookups.
     * 3. The add() method returns false if the item is already present, making it easy to trigger a rejection message.
     */

    void main() {
        // 1. Create the submission tracker collection
        var submittedStudents = new HashSet<String>();

        // 2. Incoming student submissions (including duplicates)
        var incomingSubmissions = List.of("Alice", "Bob", "Charlie", "Alice", "David", "Eve", "Bob", "Frank", "Grace");

        IO.println("--- Processing Submissions ---");

        // 3. Process submissions and reject duplicates
        for (var student : incomingSubmissions) {
            var isAdded = submittedStudents.add(student);

            if (isAdded) {
                IO.println("Success: " + student + " submission recorded.");
            } else {
                IO.println("Rejected: " + student + " has already submitted!");
            }
        }

        // 4. Print all submitted students when done
        IO.println("\n--- Final Submitted Students ---");
        IO.println(submittedStudents);
        IO.println("Total unique submissions: " + submittedStudents.size());
    }
}