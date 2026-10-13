package se.lexicon.exercises.exercise2;

public class CircleCalculator {

    void main() {
        // 1. Prompt the user to enter the radius of the circle
        double radius = Double.parseDouble(IO.readln("Enter radius: "));

        // 2. Calculate the area (pi * r^2) and circumference (2 * pi * r)
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = 2 * Math.PI * radius;

        // 3. Print the results formatted to two decimal places
        IO.println("Area         : " + String.format("%.2f", area));
        IO.println("Circumference: " + String.format("%.2f", circumference));
    }
}



