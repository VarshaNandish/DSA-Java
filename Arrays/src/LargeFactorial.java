/*
Factorial of a non-negative integer, is the multiplication of all integers smaller than or equal to n.

Factorial of a number
Factorial of a number
Examples:

Input: 100
Output: 933262154439441526816992388562667004-
         907159682643816214685929638952175999-
         932299156089414639761565182862536979-
         208272237582511852109168640000000000-
         00000000000000

Input: 50
Output: 3041409320171337804361260816606476884-
         4377641568960512000000000000

Given a non-negative integer n, find n! (factorial of n).

Factorial is defined as:

n! = n × (n-1) × (n-2) × ... × 1

For large n, the factorial value can be extremely large and cannot fit into standard data types like int or long.

In some coding environments (like competitive programming without BigInteger), we can’t use built-in big number types.

We simulate multiplication manually like we do on paper.

Idea:

Store digits of the result in an array (each cell holds one digit).

Multiply digit-by-digit, handling carry manually.

Algorithm:

Create an integer array res[] to store digits.

Initialize res[0] = 1 and resSize = 1.

For each x from 2 to n:

Multiply x with the number represented by res[].

Store result back into res[], updating carry as needed.

Print result in reverse order.

Time Complexity: O(n²) in worst case (because each multiplication can go through all stored digits).
Space Complexity: O(n) for storing digits.

 */

public class LargeFactorial {

    static void factorial(int n) {
        int[] res = new int[500]; // array to store digits
        res[0] = 1;               // factorial of 0 or 1 is 1
        int resSize = 1;          // number of digits in result

        for (int x = 2; x <= n; x++) {
            resSize = multiply(x, res, resSize);
        }

        // Print result in reverse order
        for (int i = resSize - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
    }

    static int multiply(int x, int[] res, int resSize) {
        int carry = 0;

        for (int i = 0; i < resSize; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;   // store last digit
            carry = prod / 10;    // remaining carry
        }

        // Put remaining carry in res[]
        while (carry != 0) {
            res[resSize] = carry % 10;
            carry /= 10;
            resSize++;
        }

        return resSize;
    }

    public static void main(String[] args) {
        factorial(100); // prints factorial of 100
    }
}
