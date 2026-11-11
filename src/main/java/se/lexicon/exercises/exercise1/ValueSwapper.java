package se.lexicon.exercises.exercise1;

public class ValueSwapper {
    public static void main(String[] args) {
        int a = 15;
        int b = 42;

        System.out.println("Before: a = " + a + ", b = " + b);

        // Swap values without a third variable using addition and subtraction
        a = a + b; // a is now 15 + 42 = 57
        b = a - b; // b is now 57 - 42 = 15 (original a)
        a = a - b; // a is now 57 - 15 = 42 (original b)

        System.out.println("After:  a = " + a + ", b = " + b);
    }
}
