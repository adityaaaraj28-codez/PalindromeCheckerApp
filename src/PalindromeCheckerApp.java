import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Node class for Linked List (UC8)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC9 Recursive Function
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

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

        Scanner scanner = new Scanner(System.in);

        // --------------------------------
        // UC3: User Input Palindrome Check
        // --------------------------------
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

        for (int i = 0; i < stackInput.length(); i++) {
            stack.push(stackInput.charAt(i));
        }

        String reversedStack = "";

        while (!stack.isEmpty()) {
            reversedStack = reversedStack + stack.pop();
        }

        if (stackInput.equals(reversedStack)) {
            System.out.println(stackInput + " is a Palindrome (Using Stack)");
        } else {
            System.out.println(stackInput + " is NOT a Palindrome (Using Stack)");
        }

        // --------------------------------
        // UC6: Queue + Stack Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Queue + Stack Palindrome Check: ");
        String qsInput = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < qsInput.length(); i++) {
            char ch = qsInput.charAt(i);
            queue.add(ch);
            stack2.push(ch);
        }

        boolean qsPalindrome = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack2.pop()) {
                qsPalindrome = false;
                break;
            }
        }

        if (qsPalindrome) {
            System.out.println(qsInput + " is a Palindrome (Using Queue + Stack)");
        } else {
            System.out.println(qsInput + " is NOT a Palindrome (Using Queue + Stack)");
        }

        // --------------------------------
        // UC7: Deque-Based Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Deque Based Palindrome Check: ");
        String dequeInput = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < dequeInput.length(); i++) {
            deque.addLast(dequeInput.charAt(i));
        }

        boolean dequePalindrome = true;

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                dequePalindrome = false;
                break;
            }
        }

        if (dequePalindrome) {
            System.out.println(dequeInput + " is a Palindrome (Using Deque)");
        } else {
            System.out.println(dequeInput + " is NOT a Palindrome (Using Deque)");
        }

        // --------------------------------
        // UC8: Linked List Palindrome Check
        // --------------------------------
        System.out.print("\nEnter a string for Linked List Palindrome Check: ");
        String listInput = scanner.nextLine();

        Node head = null;
        Node tail = null;

        for (char c : listInput.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean listPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                listPalindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (listPalindrome) {
            System.out.println(listInput + " is a Palindrome (Using Linked List)");
        } else {
            System.out.println(listInput + " is NOT a Palindrome (Using Linked List)");
        }

        // --------------------------------
        // UC9: Recursive Palindrome Checker
        // --------------------------------
        System.out.print("\nEnter a string for Recursive Palindrome Check: ");
        String recursiveInput = scanner.nextLine();

        boolean recursiveResult =
                isPalindromeRecursive(recursiveInput, 0, recursiveInput.length() - 1);

        if (recursiveResult) {
            System.out.println(recursiveInput + " is a Palindrome (Using Recursion)");
        } else {
            System.out.println(recursiveInput + " is NOT a Palindrome (Using Recursion)");
        }

        scanner.close();
    }
}