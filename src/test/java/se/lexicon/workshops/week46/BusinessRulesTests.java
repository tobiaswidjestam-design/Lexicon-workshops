package se.lexicon.workshops.week46;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessRulesTests {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final SubscriberProcessor processor = new SubscriberProcessor();

    @BeforeEach
    void setup() {
        subscribers.add(new Subscriber(1, "some@email.com", Plan.PRO, true, 10));
        subscribers.add(new Subscriber(2, "some1@email.com", Plan.free, false, 0));
        subscribers.add(new Subscriber(3, "some2@email.com", Plan.PRO, true, 1));
        subscribers.add(new Subscriber(4, "some3@email.com", Plan.Basic, true, 5));
        subscribers.add(new Subscriber(5, "some4@email.com", Plan.Basic, false, 3));
        subscribers.add(new Subscriber(6, "some5@email.com", Plan.free, true, 1));
        subscribers.add(new Subscriber(7, "some6@email.com", Plan.PRO, true, 7));
    }

    @Test
    @DisplayName("Display all subscribers that are active.")
    public void shouldShowActiveSubscribers() {
        List<Subscriber> activeSubscribers = processor.findSubscribers(subscribers, BusinessRules.isActive);
        assertEquals(5, activeSubscribers.size());
    }

    @Test
    @DisplayName("Display subscribers with 0 or 1 month remaining.")
    public void shouldShowExpiringSubscribers() {
        List<Subscriber> expiringSubscribers = processor.findSubscribers(subscribers, BusinessRules.isExpiring);
        assertEquals(3, expiringSubscribers.size());
    }

    @Test
    @DisplayName("Display subscribers who are active and whose subscriptions are about to expire.")
    public void shouldShowActiveAndExpiringSubscribers() {
        List<Subscriber> expiringActiveSubscribers = processor.findSubscribers(subscribers, BusinessRules.isActiveAndExpiring);
        assertEquals(2, expiringActiveSubscribers.size());
    }

    @Test
    @DisplayName("Extend subscriptions for active, paying subscribers with expiring subscriptions.")
    public void shouldExtendSubscriptions() {
        List<Subscriber> payingSubscribers = processor.findSubscribers(subscribers, BusinessRules.filterPayedPlans);
        List<Subscriber> payingActiveExpiringSubscribers = processor.findSubscribers(payingSubscribers, BusinessRules.isActiveAndExpiring);

        assertEquals(1, payingActiveExpiringSubscribers.size());
        assertEquals(1, payingActiveExpiringSubscribers.getFirst().getMonthsRemaining());

        List<Subscriber> result = processor.applyToMatching(payingSubscribers, BusinessRules.isActiveAndExpiring, BusinessRules.extendSubscription(3));
        assertEquals(1, result.size());
        assertEquals(4, result.getFirst().getMonthsRemaining());
    }

    @Test
    @DisplayName("Deactivate free subscribers whose subscriptions have expired.")
    public void shouldDeactivateSubscriptions() {
        List<Subscriber> freeSubscribers = processor.findSubscribers(subscribers, BusinessRules.filterByPlan(Plan.free));
        List<Subscriber> freeActiveSubscribers = processor.findSubscribers(freeSubscribers, BusinessRules.isActive);

        assertEquals(1, freeActiveSubscribers.size());
        assertTrue(freeActiveSubscribers.getFirst().isActive());

        freeActiveSubscribers = processor.applyToMatching(freeSubscribers, BusinessRules.isActive, BusinessRules.deactivateSubscriber);
        assertEquals(1, freeActiveSubscribers.size());
        assertFalse(freeActiveSubscribers.getFirst().isActive());
    }

    @Test
    @DisplayName("Display subscribers based on their subscription plan (FREE, BASIC, or PRO).")
    public void shouldFilterSubscriptionsByPlan() {
        List<Subscriber> freeSubscribers = processor.findSubscribers(subscribers, BusinessRules.filterByPlan(Plan.free));

        assertEquals(2, freeSubscribers.size());
        assertEquals(Plan.free, freeSubscribers.getFirst().getPlan());
        assertEquals(Plan.free, freeSubscribers.get(1).getPlan());
    }
}
