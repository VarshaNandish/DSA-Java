/*
Let 1 maps to 'A', 2 maps to 'B', ..., 26 to 'Z'. Given a digit sequence, count the number of possible decodings of the given digit sequence.

Consider the input string "123". There are three valid ways to decode it:

    "ABC": The grouping is (1, 2, 3) → 'A', 'B', 'C'
    "AW": The grouping is (1, 23) → 'A', 'W'
    "LC": The grouping is (12, 3) → 'L', 'C'

Note: Groupings that contain invalid codes (e.g., "0" by itself or numbers greater than "26") are not allowed.
For instance, the string "230" is invalid because "0" cannot stand alone, and "30" is greater than "26", so it cannot represent any letter. The task is to find the total number of valid ways to decode a given string.

Examples:

    Input: digits = "121"
    Output: 3
    Explanation: The possible decodings are "ABA", "AU", "LA"

    Input: digits = "1234"
    Output: 3
    Explanation: The possible decodings are "ABCD", "LCD", "AWD"
Problem Restatement
We’re given a string of digits (e.g., "123"). Each digit (1–26) maps to letters A–Z.
We must count the total number of valid decodings.
Constraints:
"0" cannot be decoded alone.
Only numbers 1–26 are valid codes.
Naive Recursive Idea
At any index i:
1. Take one digit if it’s 1–9.
2. Take two digits if it’s 10–26.
So:
ways(i) = ways(i+1) + ways(i+2) (if valid)
But recursion repeats subproblems → exponential time. So we use DP.
DP Approach
We’ll use a 1D DP array where:
dp[i] = number of ways to decode substring digits[0..i-1].
Initialization
dp[0] = 1 (empty string has 1 way).
dp[1] = 1 if digits[0] != '0', else 0.
Transition
For i from 2 to n:
If digits[i-1] != '0', then:
dp[i] += dp[i-1]
 If the two-digit number digits[i-2..i-1] is between 10–26:
               dp[i] += dp[i-2]
Answer
dp[n] = total number of decodings.
*/
public class DecodeWays {
    public static int numDecodings(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty string
        dp[1] = 1;  // First char already validated

        for (int i = 2; i <= n; i++) {
            // Single digit (must not be '0')
            if (digits.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digits (must be 10 to 26)
            int twoDigit = Integer.parseInt(digits.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("121"));   // 3
        System.out.println(numDecodings("1234"));  // 3
        System.out.println(numDecodings("230"));   // 0
    }
}


