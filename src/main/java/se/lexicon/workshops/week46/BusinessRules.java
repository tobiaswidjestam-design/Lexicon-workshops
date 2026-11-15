package se.lexicon.workshops.week46;

public final class BusinessRules {
    private BusinessRules() {}

    // 1. Active Subscriber: Identify subscribers with active accounts.
    public static final SubscriberFilter isActive = Subscriber::isActive;

    // 2. Expiring Subscription: Identify subscribers with 0 or 1 month remaining.
    public static final SubscriberFilter isExpiring = s -> s.getMonthsRemaining() <= 1;

    // 3. Active and Expiring Subscriber: Identify active subscribers whose subscriptions are about to expire.
    public static final SubscriberFilter isActiveAndExpiring = s -> s.getMonthsRemaining() <= 1 && s.isActive();

    // 4. Subscriber by Plan: Filter subscribers by FREE, BASIC, or PRO plans.
    public static SubscriberFilter filterByPlan(Plan plan){
        return s -> s.getPlan() == plan;
    }

    // 5. Paying Subscriber: Identify subscribers with paid plans (BASIC or PRO).
    public static final SubscriberFilter filterPayedPlans = s -> s.getPlan() == Plan.PRO || s.getPlan() == Plan.Basic;

    // 6. Extend Subscription: Increase a subscriber's remaining subscription period.
    public static SubscriberAction extendSubscription(int months) {
        return s -> s.setMonthsRemaining(s.getMonthsRemaining() + months);
    }

    // 7. Deactivate Subscriber: Mark a subscriber's account as inactive.
    public static final SubscriberAction deactivateSubscriber = s -> s.setActive(false);
}
