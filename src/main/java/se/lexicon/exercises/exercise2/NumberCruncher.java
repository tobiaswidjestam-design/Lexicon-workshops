package se.lexicon.exercises.exercise2;

public class NumberCruncher {

    void main() {
        // 1. Prompt the user to enter three integers
        int num1 = Integer.parseInt(IO.readln("Enter first number : "));
        int num2 = Integer.parseInt(IO.readln("Enter second number: "));
        int num3 = Integer.parseInt(IO.readln("Enter third number : "));

        // 2. Call the static methods to calculate max, min, and average
        int max = findMax(num1, num2, num3);
        int min = findMin(num1, num2, num3);
        double avg = average(num1, num2, num3);

        // 3. Print the results matching the example layout
        IO.println("Maximum : " + max);
        IO.println("Minimum : " + min);
        IO.println("Average : " + String.format("%.2f", avg));
    }

    // Static method to find the maximum of three integers
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Static method to find the minimum of three integers
    public static int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Static method to calculate the average of three integers
    public static double average(int a, int b, int c) {
        return (a + b + (double) c) / 3;
    }
}





