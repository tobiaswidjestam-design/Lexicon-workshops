import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class ConcertQueueExercise10 {

    /*
     * Chosen Collection: ArrayDeque (implementing Queue)
     * Reason:
     * 1. It operates on a First-In-First-Out (FIFO) principle, which precisely matches a concert queue.
     * 2. It provides efficient O(1) time complexity for adding elements to the back and removing from the front.
     * 3. It naturally maintains the exact arrival order of the people waiting in line.
     */

    void main() {
        // 1. Create the concert queue
        Queue<String> concertQueue = new ArrayDeque<>();

        // 2. Add at least 6 people to the queue
        var initialPeople = List.of("Alice", "Bob", "Charlie", "Diana", "Eve", "Frank");
        concertQueue.addAll(initialPeople);

        IO.println("--- Concert Queue Management ---");
        IO.println("Initial queue: " + concertQueue);

        // 3. Let in (remove and print) 2 people from the front
        IO.println("\nLetting people in:");
        IO.println("Entered venue: " + concertQueue.poll());
        IO.println("Entered venue: " + concertQueue.poll());

        // 4. Print the remaining queue in order
        IO.println("\nRemaining queue outside:");
        for (var person : concertQueue) {
            IO.println("- " + person);
        }

        IO.println("Total people still waiting: " + concertQueue.size());
    }
}