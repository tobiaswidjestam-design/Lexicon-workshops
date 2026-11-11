package se.lexicon.exercises.Functional_Programming;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PersonStreamTest {

    void main() {
        // Sample list of people
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // Core Task 1: Filter all active people
        IO.println("--- 1. Active People ---");
        List<Person> activePeople = people.stream()
                .filter(Person::isActive)
                .toList();
        activePeople.forEach(IO::println);

        // Core Task 2: Map all names (extract just the names as a List<String>)
        IO.println("\n--- 2. All Names ---");
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        names.forEach(IO::println);

        // Core Task 3: Count adults (age >= 18)
        IO.println("\n--- 3. Count Adults ---");
        long adultCount = people.stream()
                .filter(p -> p.getAge() >= 18)
                .count();
        IO.println("Number of adults: " + adultCount);

        // Core Task 4: Sort by age
        IO.println("\n--- 4. Sorted by Age ---");
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();
        sortedByAge.forEach(IO::println);

        // Core Task 5: Find first active person in Stockholm
        IO.println("\n--- 5. First Active Person in Stockholm ---");
        Optional<Person> firstStockholmer = people.stream()
                .filter(p -> p.isActive())
                .filter(p -> p.getCity().equalsIgnoreCase("Stockholm"))
                .findFirst();

        // Check if found and print
        if (firstStockholmer.isPresent()) {
            IO.println(firstStockholmer.get());
        } else {
            IO.println("No matching person found.");
        }
    }
}