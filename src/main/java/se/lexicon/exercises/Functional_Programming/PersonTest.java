package se.lexicon.exercises.Functional_Programming;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
        void main(String[] args) {
        // Example list from the exercise
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // Write lambda rules (Core Tasks 1 & 2)
        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule livesInStockholm = person -> person.getCity().equalsIgnoreCase("Stockholm");

        // Test filtering everyone who lives in Stockholm
        IO.println("--- Personer som bor i Stockholm ---");
        List<Person> stockholmers = filterPeople(people, livesInStockholm);
        for (Person p : stockholmers) {
            System.out.println(p);
        }
    }

    // Filter method that uses our interface (Core Task 3)
    public static List<Person> filterPeople(List<Person> list, PersonRule rule) {
        List<Person> result = new ArrayList<>();
        for (Person p : list) {
            if (rule.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}