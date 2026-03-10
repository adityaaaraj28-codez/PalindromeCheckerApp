import java.util.Scanner;
import java.util.Stack;

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
        // UC4: Character Array Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Character Array Palindrome Check: ");
        String arrayInput = scanner.nextLine();

        char[] characters = arrayInput.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

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

        // --------------------------------
        // UC5: Stack-Based Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Stack Based Palindrome Check: ");
        String stackInput = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < stackInput.length(); i++) {
            stack.push(stackInput.charAt(i));
        }

        String reversedStack = "";

        // Pop characters from stack
        while (!stack.isEmpty()) {
            reversedStack = reversedStack + stack.pop();
        }

        if (stackInput.equals(reversedStack)) {
            System.out.println(stackInput + " is a Palindrome (Using Stack)");
        } else {
            System.out.println(stackInput + " is NOT a Palindrome (Using Stack)");
        }

        scanner.close();
    }
}