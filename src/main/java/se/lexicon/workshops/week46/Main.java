package se.lexicon.workshops.week46;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    static SubscriberDAO subscriberDAO = new SubscriberDAO();
    static int id = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("Welcome to subscriber app");
        System.out.println("Choose an option");
        System.out.println("1. create subscription");
        System.out.println("2. list subscriptions");
        System.out.println("3. find subscription by ID");
        System.out.println("4. exit");

        while (true) {
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createSubscription();
                    break;
                case "2":
                    listSubscriptions();
                    break;
                case "3":
                    findSubscriptionByID();
                    break;
                case "4":
                    System.exit(0);
                    break;
            }
        }
    }

    public static void findSubscriptionByID (){
        System.out.println("id: ");
        String id = scanner.nextLine();
        System.out.println(subscriberDAO.findById(parseInt(id)));
    }

    public static void createSubscription() {
        System.out.println("email: ");
        String email = scanner.nextLine();
        subscriberDAO.save(new Subscriber(++id, email, Plan.PRO, true, 12));
        System.out.println(subscriberDAO.findById(id));
    }

    public static void listSubscriptions (){
        System.out.println(subscriberDAO.findAll());
    }
}
