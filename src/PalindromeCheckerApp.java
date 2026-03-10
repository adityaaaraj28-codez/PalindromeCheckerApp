import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // -------------------------------
        // UC1: Welcome Message
        // -------------------------------
        System.out.println("Welcome to Palindrome Checker App");


        // -------------------------------
        // UC2: Hardcoded Palindrome Check
        // -------------------------------
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }


        // -------------------------------
        // UC3: User Input Palindrome Check
        // -------------------------------
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word to check: ");
        String input = sc.nextLine();

        String reverseInput = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseInput = reverseInput + input.charAt(i);
        }

        if (input.equalsIgnoreCase(reverseInput)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        sc.close();
    }
}