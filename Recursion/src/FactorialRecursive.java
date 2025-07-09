/*

Problem Statement

Given a number n, compute its factorial, defined as:

Approach : Naive Recursion

factorial(n) = n × factorial(n-1)

factorial(0) = 1 (base case)


Time Complexity: O(n)Each function call reduces n by 1.
Space Complexity: O(n)Due to recursive call stack (one per level).

*/

public class FactorialRecursive {

    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0) return 1;  // Base case: 0! = 1
        return n * factorial(n - 1);  // Recursive call
    }

    public static void main(String[] args) {
        int num = 5;

        // Print factorial of the number
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}

 