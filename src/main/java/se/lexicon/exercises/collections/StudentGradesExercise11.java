package se.lexicon.exercises.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentGradesExercise11 {

    /*
     * Chosen Collection: HashMap
     * Reason & Sorting Strategy:
     * 1. A HashMap is ideal for fast lookups by student name (key-value pairs of String -> Integer).
     * 2. To print students sorted by grade from highest to lowest, we extract the map entries into a List
     *    and sort them using a custom Comparator comparing the grade values in descending order.
     */

    void main() {
        // 1. Store student grades (name -> grade)
        var studentGrades = new HashMap<String, Integer>();
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("Diana", 95);
        studentGrades.put("Eve", 88);
        studentGrades.put("Frank", 90);

        // 2. Look up a specific student's grade quickly
        var searchName = "Diana";
        IO.println("--- Student Grades Lookup ---");
        IO.println("Grade for " + searchName + ": " + studentGrades.get(searchName));

        // 3. Print all students sorted by grade from highest to lowest
        IO.println("\n--- Students Sorted by Grade (Highest to Lowest) ---");

        // Convert entries to a list to enable sorting by value (grade)
        var sortedEntries = new ArrayList<>(studentGrades.entrySet());

        // Sort descending: compare second value (grade) to first value
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print the sorted list
        for (var entry : sortedEntries) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}