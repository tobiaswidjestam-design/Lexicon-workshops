package se.lexicon.workshops.week46;

@FunctionalInterface
public interface SubscriberAction {
    void run(Subscriber subscriber);
}
