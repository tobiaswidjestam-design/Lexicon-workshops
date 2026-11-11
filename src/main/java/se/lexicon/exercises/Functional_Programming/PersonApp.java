package se.lexicon.exercises.Functional_Programming;

import java.util.ArrayList;
import java.util.List;

public class PersonApp {

    // Modern Java instance main method (no String[] args required)
    void main() {
        // Starter data list
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // Define rules using lambda expressions and method references (Part 1 - No Streams)
        PersonRule isActive = Person::isActive; // Method reference
        PersonRule isAdult = p -> p.getAge() >= 18; // Lambda expression
        PersonRule livesInStockholm = p -> p.getCity().equalsIgnoreCase("Stockholm");

        // Define custom actions using lambdas
        PersonAction printName = p -> IO.println("Name: " + p.getName());
        PersonAction sendEmail = p -> IO.println("Sending email to: " + p.getName());

        // Filter and process people living in Stockholm
        IO.println("--- People living in Stockholm ---");
        List<Person> stockholmers = filterPeople(people, livesInStockholm);
        for (Person p : stockholmers) {
            printName.execute(p);
        }

        // Filter and process active people
        IO.println("\n--- Active people ---");
        List<Person> activePeople = filterPeople(people, isActive);
        for (Person p : activePeople) {
            sendEmail.execute(p);
        }
    }

    // Custom filtering method using standard iteration instead of Stream API
    public List<Person> filterPeople(List<Person> list, PersonRule rule) {
        List<Person> result = new ArrayList<>();
        for (Person p : list) {
            if (rule.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}