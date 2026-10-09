package se.lexicon.exercises.exercise1;

public class ValueSwapper {
    public static void main(String[] args) {
        int a = 15;
        int b = 42;

        System.out.println("Before: a = " + a + ", b = " + b);

        // Byt värden utan en tredje variabel med hjälp av addition och subtraktion
        a = a + b; // a blir nu 15 + 42 = 57
        b = a - b; // b blir nu 57 - 42 = 15 (ursprungliga a)
        a = a - b; // a blir nu 57 - 15 = 42 (ursprungliga b)

        System.out.println("After:  a = " + a + ", b = " + b);
    }
}
