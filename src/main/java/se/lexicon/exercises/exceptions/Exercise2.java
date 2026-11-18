package se.lexicon.exercises.exceptions;


public class Exercise2 {

    void main() {

        try {

            IO.print("Enter an integer between 1 and 100: ");

            int number = Integer.parseInt(IO.readln());

            if (number < 1 || number > 100) {
                throw new OutOfRangeException(
                        "Number is outside the allowed range!"
                );
            }

            IO.println("Valid number: " + number);

        } catch (NumberFormatException e) {

            IO.println("Invalid input! Please enter an integer.");

        } catch (OutOfRangeException e) {

            IO.println(e.getMessage());
        }
    }
}


class OutOfRangeException extends Exception {

    public OutOfRangeException(String message) {
        super(message);
    }
}
