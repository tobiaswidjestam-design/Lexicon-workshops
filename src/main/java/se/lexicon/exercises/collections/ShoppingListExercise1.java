package se.lexicon.exercises.collections;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListExercise1 {

    void main() {
        // 1. Create an ArrayList<String> and add 5 items using modern Java syntax
        var shoppingList = new ArrayList<>(List.of("Milk", "Eggs", "Bread", "Butter", "Coffee"));

        // 2. Print all items numbered (1, 2, 3...)
        IO.println("--- Initial Shopping List ---");
        var counter = 1;
        for (var item : shoppingList) {
            IO.println(counter++ + ". " + item);
        }

        // 3. Remove one item by name
        shoppingList.remove("Eggs");
        IO.println("\n(Removed 'Eggs' from the list...)");

        // 4. Print the updated list
        IO.println("\n--- Updated Shopping List ---");
        counter = 1; // Nollställer räknaren för den uppdaterade listan
        for (var item : shoppingList) {
            IO.println(counter++ + ". " + item);
        }
    }
}



