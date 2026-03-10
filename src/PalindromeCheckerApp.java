import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // --------------------------------
        // UC1: Welcome Message
        // --------------------------------
        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println("=================================");

        // --------------------------------
        // UC2: Hardcoded Palindrome Check
        // --------------------------------
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

        // --------------------------------
        // UC3: User Input Palindrome Check
        // --------------------------------
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a word to check palindrome: ");
        String input = scanner.nextLine();

        String reverseInput = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseInput = reverseInput + input.charAt(i);
        }

        if (input.equalsIgnoreCase(reverseInput)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        // --------------------------------
        // UC4: Character Array Based Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Character Array Palindrome Check: ");
        String arrayInput = scanner.nextLine();

        // Convert string to char array
        char[] characters = arrayInput.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(arrayInput + " is a Palindrome (Using Character Array)");
        } else {
            System.out.println(arrayInput + " is NOT a Palindrome (Using Character Array)");
        }

        scanner.close();
    }
}