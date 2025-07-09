/*

Problem Statement

Write a Java program to compute the n-th Fibonacci number and also print the Fibonacci series up to n terms.

Approach : Naive Recursion (Exponential Time)

Algorithm Description:
Use direct recursion:
fib(n) = fib(n-1) + fib(n-2)
This approach recomputes values many times → very inefficient!

Time Complexity: O(2^n) (Exponential)
Space Complexity: O(n) (due to recursion stack)

*/

public class FibonacciNaive {

    // Naive recursive method
    public static int fib(int n) {

        if (n <= 1) return n;  // Base cases: fib(0)=0, fib(1)=1
        return fib(n - 1) + fib(n - 2);  // Recursive case
    }

    public static void main(String[] args) {

        int n = 8; // Change this for different terms

        System.out.println("Fibonacci series up to " + n + " terms:");

        for (int i = 0; i < n; i++) {

            System.out.print(fib(i) + " ");

        }
    }
}


