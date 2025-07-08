/*


Recursive Function to Sum Digits of a Positive Integer

Logic:
Base Case: If the number becomes 0, return 0.
Recursive Step: Add the last digit (num % 10) and recurse on the rest (num / 10).

Time Complexity: O(d)

Dry Run for Number 456:

Sum of Digits:

sumDigits(456)

→ 6 + sumDigits(45)

→ 6 + 5 + sumDigits(4)

→ 6 + 5 + 4 + sumDigits(0)

→ 15

*/



public class DigitSummer {

    // Recursive function to sum digits
    public static int sumDigits(int num) {

        // Base case: when number is 0
        if (num == 0) {
            return 0;
        }

        // Recursive step: add last digit and recurse on the rest
        return (num % 10) + sumDigits(num / 10);
    }

    public static void main(String[] args) {

        int number = 45678;

        int sum = sumDigits(number);

        System.out.println("Sum of digits in " + number + " is: " + sum);

    }
}