package se.lexicon.exercises.exercise2;

public class EmailSlicer {


    void main(){

        // 1. Prompt the user to enter an email address
        String email = IO.readln("Enter a valid email address: ");
        // 2. Find the index position of the '@' character
        int atIndex = email.indexOf("@");
        // 3. Extract the username from the beginning up to the '@' sign
        String username = email.substring(0, atIndex);
        // 4. Extract the domain from right after the '@' sign to the end
        String domain = email.substring(atIndex + 1);

        // 5. Print the extracted parts
        IO.println("Username: " + username);
        IO.println("Domain  : " + domain);


    }

}
