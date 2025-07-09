/*
Problem Statement

Given a number n, compute its factorial, defined as:

Approach : Iterative (Expected & Efficient)
How it Works:
Initialize result as 1
Use a loop:
        for i from 2 to n:

result *= i

Time Complexity: O(n)
Space Complexity: O(1)

*/

public class FactorialIterative {

    // Iterative function to calculate factorial
    public static int factorial(int n) {
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;  // Multiply result by current number
        }

        return result;
    }

    public static void main(String[] args) {

        int num = 5;

        // Print factorial of the number
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}