package se.lexicon.exercises.exercise2;

public class WordReverser {


    // Modern Java main method using Java 26 preview features
    void main(){

        // 1. Prompt the user to enter a word and read the input using the IO helper class
        String word = IO.readln("Enter a word : ");

        // 2. Reverse the word using StringBuilder
        String reversed = new StringBuilder(word).reverse().toString();

        // 3. Print the result using IO.println()
        IO.println("Your word is : " + reversed);

    }



}
