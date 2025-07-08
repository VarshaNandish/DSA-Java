/*

Recursive Function to Count Digits of a Positive Integer

Logic:
Base Case: If the number becomes 0, return 0.
Recursive Step: Divide the number by 10 and add 1 (removing one digit per call).

Time Complexity: O(d)
(where d = number of digits)

Dry Run for Number 456:
Count Digits:
countDigits(456)

→ 1 + countDigits(45)

→ 1 + 1 + countDigits(4)

→ 1 + 1 + 1 + countDigits(0)

→ 3

*/



public class DigitCounter {

    // Recursive function to count digits
    public static int countDigits(int num) {

        // Base case: when number is 0
        if (num == 0) {
            return 0;
        }

        // Recursive step: strip one digit and count
        return 1 + countDigits(num / 10);
    }

    public static void main(String[] args) {

        int number = 45678;

        int count = countDigits(number);

        System.out.println("Number of digits in " + number + " is: " + count);

    }
}