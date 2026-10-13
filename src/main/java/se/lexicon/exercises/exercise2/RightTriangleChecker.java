package se.lexicon.exercises.exercise2;
import java.util.Arrays;


public class RightTriangleChecker {

    void main() {
        // 1. Prompt the user to enter the lengths of three sides of a triangle
        double a = Double.parseDouble(IO.readln("Enter side a: "));
        double b = Double.parseDouble(IO.readln("Enter side b: "));
        double c = Double.parseDouble(IO.readln("Enter side c: "));

        // 2. Store the sides in an array and sort them in ascending order
        // This automatically puts the longest side at the end (index 2)
        double[] sides = {a, b, c};
        Arrays.sort(sides);

        double shortLeg = sides[0];
        double mediumLeg = sides[1];
        double longest = sides[2];

        // 3. Check Pythagorean theorem: shortLeg^2 + mediumLeg^2 == longest^2
        // Using a tiny epsilon value to handle potential floating-point precision issues
        boolean isRightTriangle = Math.abs((shortLeg * shortLeg + mediumLeg * mediumLeg) - (longest * longest)) < 0.0001;

        // 4. Print the longest side and the result
        IO.println("Longest side: " + longest);
        if (isRightTriangle) {
            IO.println("This IS a right triangle.");
        } else {
            IO.println("This is NOT a right triangle.");
        }
    }
}



