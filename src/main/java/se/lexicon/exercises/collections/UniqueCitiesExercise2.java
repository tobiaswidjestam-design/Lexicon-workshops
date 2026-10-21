import java.util.LinkedHashSet;
import java.util.List;

public class UniqueCitiesExercise2 {

    void main() {
        // 1. Given list of cities (where Stockholm and Gothenburg appear multiple times)
        var inputCities = List.of("Stockholm", "Gothenburg", "Malmö", "Stockholm", "Uppsala", "Gothenburg", "Lund");

        // 2. Store them in a collection that automatically handles duplicates
        var uniqueCities = new LinkedHashSet<>(inputCities);

        // 3. Print all unique cities and the total count
        IO.println("--- Unique Cities ---");
        for (var city : uniqueCities) {
            IO.println("- " + city);
        }

        IO.println("\nTotal count of unique cities: " + uniqueCities.size());
    }
}