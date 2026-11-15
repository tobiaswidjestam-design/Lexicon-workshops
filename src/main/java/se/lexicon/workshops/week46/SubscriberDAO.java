package se.lexicon.workshops.week46;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubscriberDAO {

    private final List<Subscriber> subscribers = new ArrayList<>();

    public void save(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Returns a copy of the list
    public List<Subscriber> findAll() {
        return new ArrayList<>(subscribers);
    }

    public Optional<Subscriber> findById(int id) {
        return subscribers.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }
}