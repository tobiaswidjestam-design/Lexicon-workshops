package se.lexicon.exercises.exercise1;

public class ProfileCard {


    public static void main(String[] args) {

        String name = "Tobias";
        int age = 50;
        String city = "Ryssby";
        printLine();
        System.out.println("\nName:" + name + "\nAge:" + age + "\nCity:" + city);
        printLine();

    }

    public static void printLine() {

        for (int i = 1; i < 20; i++) {
            System.out.print("=");
        }


    }




}
