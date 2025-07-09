/*
Problem Statement

Write a Java program to print all palindrome numbers between 1 and a given number n.

Approach : Naive — Check Each Number by Reversing it.

How It Works?
Loop from 1 to n.

For each number:
Reverse its digits.
Compare the reversed number to the original.
If equal → it's a palindrome → print/store it.

Time: O(d) → d = number of digits
Space: O(1) → no extra memory used

*/

public class PalindromeSeries {

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;           // Extract last digit
            reversed = reversed * 10 + digit; // Append digit in reverse order
            num /= 10;                      // Remove last digit
        }

        // Compare reversed with original
        return original == reversed;
    }

    // Function to print palindrome numbers up to n
    public static void printPalindromeSeries(int n) {

        System.out.println("Palindrome numbers from 1 to " + n + ":");

        for (int i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // For new line
    }

    public static void main(String[] args) {

        int n = 150; // You can change this value for different ranges

        printPalindromeSeries(n);
    }
}


