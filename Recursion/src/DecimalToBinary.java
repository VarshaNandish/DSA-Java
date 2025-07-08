/*

Problem
Given a positive integer in decimal (base 10), write a recursive function that returns its binary representation (base 2) as a string.

Logic and Approach:
Key Idea:
To convert a decimal number n to binary:

Base Case:
If n == 0, return an empty string "" (or "0" for the complete result).

Recursive Step:
Binary of n = binary of n / 2 + n % 2 (remainder)

This uses the idea that dividing by 2 and taking remainders gives binary digits from MSB to LSB.

Time and Space Complexity:
Time: O(log n)
Space (stack): O(log n)

Dry Run for number = 13:
Binary of 13 is 1101.

toBinary(13) → toBinary(6) + "1"

toBinary(6) → toBinary(3) + "0"

toBinary(3) → toBinary(1) + "1"

toBinary(1) → toBinary(0) + "1"

toBinary(0) → ""

Build result: "" + "1" + "1" + "0" + "1" → "1101"

*/



public class DecimalToBinary {

    // Recursive function to convert decimal to binary
    public static String toBinary(int n) {

        // Base case: 0 or 1
        if (n == 0) {
            return "";
        }

        // Recursive call: divide by 2 and append remainder
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        int number = 13;

        // Handle the special case when number is 0
        String binary = (number == 0) ? "0" : toBinary(number);

        System.out.println("Decimal: " + number);

        System.out.println("Binary: " + binary);

    }
}