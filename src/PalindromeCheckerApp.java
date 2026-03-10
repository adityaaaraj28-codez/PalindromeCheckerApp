
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("Welcome to Palindrome Checker App");

        // UC2 - Hardcoded Palindrome
        String word = "madam";
        String reversed = "";

        for(int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if(word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        }
        else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}