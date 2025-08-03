/*
Given two strings, s1 and s2, the task is to find the length of the Longest Common Subsequence. If there is no common subsequence, return 0. A subsequence is a string generated from the original string by deleting 0 or more characters, without changing the relative order of the remaining characters.

For example, subsequences of "ABC" are "", "A", "B", "C", "AB", "AC", "BC" and "ABC". In general, a string of length n has 2n subsequences.

Examples:

Input: s1 = "ABC", s2 = "ACD"
Output: 2
Explanation: The longest subsequence which is present in both strings is "AC".

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 4
Explanation: The longest common subsequence is "GTAB".

Input: s1 = "ABC", s2 = "CBA"
Output: 1
Explanation: There are three longest common subsequences of length 1, "A", "B" and "C".

Approach: Dynamic Programming (Tabulation)
We use a 2D DP table where dp[i][j] represents the length of the LCS of:
First i characters of s1
First j characters of s2

Transition Logic:
If characters match:
s1[i-1] == s2[j-1] → dp[i][j] = 1 + dp[i-1][j-1]
Else:
dp[i][j] = max(dp[i-1][j], dp[i][j-1])

Base Case:
If either string is empty, LCS is 0:
dp[0][j] = 0 and dp[i][0] = 0
 */


public class LongestCommonSubsequence {

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a DP table of size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, take diagonal + 1
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, take max from top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];  // Final LCS length
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Length of LCS: " + lcs(s1, s2)); // Output: 4
    }
}
