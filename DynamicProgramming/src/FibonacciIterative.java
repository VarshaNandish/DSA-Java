/*

Problem Statement

Write a Java program to compute the n-th Fibonacci number and also print the Fibonacci series up to n terms.

Approach : Iterative DP (Optimal & Expected in Interviews)

Algorithm Description:
Use dynamic programming (bottom-up) to store computed values.
Start from 0 and build up to n.
Store only last two values, since only they’re needed.

Time Complexity: O(n)
Space Complexity: O(1) (constant space — no array)

*/
public class FibonacciIterative {

    // Optimized space DP approach
    public static int fib(int n) {

        if (n <= 1) return n;
        int a = 0, b = 1; // F(0), F(1)
        int c = 0;

        for (int i = 2; i <= n; i++) {

            c = a + b;   // Current fib = sum of previous two
            a = b;       // Move forward
         b = c;
        }

        return c;
    }

    public static void main(String[] args) {

        int n = 8;

        System.out.println("Fibonacci series up to " + n + " terms:");

        for (int i = 0; i < n; i++) {

            System.out.print(fib(i) + " ");

        }
    }
}
