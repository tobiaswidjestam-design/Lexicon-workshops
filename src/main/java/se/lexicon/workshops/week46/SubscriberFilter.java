package se.lexicon.workshops.week46;

@FunctionalInterface
public interface SubscriberFilter {
    boolean matches(Subscriber subscriber);
}
