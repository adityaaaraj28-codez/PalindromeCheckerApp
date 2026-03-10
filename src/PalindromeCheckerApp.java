import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

// --------------------------------
// UC11: Palindrome Service Class
// --------------------------------
class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

// --------------------------------
// UC12: Strategy Pattern Interface
// --------------------------------
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }
}

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

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Palindrome Checker App ");
        System.out.println("=================================");

        // UC2 Hardcoded
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        }

        Scanner scanner = new Scanner(System.in);

        // UC3
        System.out.print("\nEnter a word to check palindrome: ");
        String input = scanner.nextLine();

        String reverseInput = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverseInput += input.charAt(i);
        }

        if (input.equalsIgnoreCase(reverseInput)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        // UC4 Character Array
        System.out.print("\nEnter string for Character Array Check: ");
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

        System.out.println(isPalindrome ?
                arrayInput + " is a Palindrome (Array)" :
                arrayInput + " is NOT a Palindrome (Array)");

        // UC5 Stack
        System.out.print("\nEnter string for Stack Check: ");
        String stackInput = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : stackInput.toCharArray()) {
            stack.push(c);
        }

        String reversedStack = "";

        while (!stack.isEmpty()) {
            reversedStack += stack.pop();
        }

        System.out.println(stackInput.equals(reversedStack) ?
                stackInput + " is Palindrome (Stack)" :
                stackInput + " is NOT Palindrome (Stack)");

        // UC6 Queue + Stack
        System.out.print("\nEnter string for Queue+Stack Check: ");
        String qsInput = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : qsInput.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean qsPalindrome = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack2.pop()) {
                qsPalindrome = false;
                break;
            }
        }

        System.out.println(qsPalindrome ?
                qsInput + " is Palindrome (Queue+Stack)" :
                qsInput + " is NOT Palindrome (Queue+Stack)");

        // UC7 Deque
        System.out.print("\nEnter string for Deque Check: ");
        String dequeInput = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : dequeInput.toCharArray()) {
            deque.addLast(c);
        }

        boolean dequePalindrome = true;

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                dequePalindrome = false;
                break;
            }
        }

        System.out.println(dequePalindrome ?
                dequeInput + " is Palindrome (Deque)" :
                dequeInput + " is NOT Palindrome (Deque)");

        // UC8 Linked List
        System.out.print("\nEnter string for Linked List Check: ");
        String listInput = scanner.nextLine();

        Node head = null, tail = null;

        for (char c : listInput.toCharArray()) {

            Node newNode = new Node(c);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;

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

        System.out.println(listPalindrome ?
                listInput + " is Palindrome (Linked List)" :
                listInput + " is NOT Palindrome (Linked List)");

        // UC9 Recursion
        System.out.print("\nEnter string for Recursive Check: ");
        String recursiveInput = scanner.nextLine();

        boolean recursiveResult =
                isPalindromeRecursive(recursiveInput, 0, recursiveInput.length() - 1);

        System.out.println(recursiveResult ?
                recursiveInput + " is Palindrome (Recursion)" :
                recursiveInput + " is NOT Palindrome (Recursion)");

        // UC10 Case Insensitive
        System.out.print("\nEnter string for Case-Insensitive Check: ");
        String caseInput = scanner.nextLine();

        String normalized = caseInput.replaceAll("\\s+", "").toLowerCase();

        String reversedCase = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversedCase += normalized.charAt(i);
        }

        System.out.println(normalized.equals(reversedCase) ?
                caseInput + " is Palindrome (Ignore Case & Space)" :
                caseInput + " is NOT Palindrome (Ignore Case & Space)");

        // UC11 OOP Service
        System.out.print("\nEnter string for OOP Service Check: ");
        String oopInput = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        System.out.println(checker.checkPalindrome(oopInput) ?
                oopInput + " is Palindrome (OOP Service)" :
                oopInput + " is NOT Palindrome (OOP Service)");

        // UC12 Strategy Pattern
        System.out.print("\nEnter string for Strategy Pattern Check: ");
        String strategyInput = scanner.nextLine();

        System.out.println("Choose Algorithm: 1.Stack  2.Deque");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        System.out.println(strategy.check(strategyInput) ?
                strategyInput + " is Palindrome (Strategy)" :
                strategyInput + " is NOT Palindrome (Strategy)");

        // UC13 Performance Comparison
        System.out.println("\n--- UC13 Performance Comparison ---");

        String test = strategyInput;

        long startTime = System.nanoTime();
        new StackStrategy().check(test);
        long endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        new DequeStrategy().check(test);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        System.out.println("Stack Strategy Time: " + stackTime + " ns");
        System.out.println("Deque Strategy Time: " + dequeTime + " ns");

        scanner.close();
    }
}