/*
Given an array arr[] of size n, the task is to find the length of the Longest Increasing Subsequence (LIS) i.e., the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.

Examples:

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest increasing subsequence is 3, 10, 20

Input: arr[] = [30, 20, 10]
Output:1
Explanation: The longest increasing subsequences are [30], [20] and [10]

Input: arr[] = [2, 2, 2]
Output: 1
Explanation:  We consider only strictly increasing.

Input: arr[] = [10, 20, 35, 80]
Output: 4
Explanation: The whole array is sorted

Approach: Dynamic Programming (DP)
Idea:
For each element in the array, we compute the longest increasing subsequence ending at that element.

We store the length in a dp[] array where:

dp[i] = length of the LIS ending at index i.

Steps:
Initialize a DP array dp[] of size n with all 1s because every element itself is a subsequence of length 1.
For each index i from 1 to n-1:
  For each j from 0 to i-1:
    If arr[i] > arr[j], then dp[i] = max(dp[i], dp[j] + 1)
The final answer is the maximum value in the dp[] array.
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        // Every element is a LIS of at least length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill dp[] using the above logic
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum in dp[]
        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        System.out.println("Length of LIS: " + lengthOfLIS(arr)); // Output: 3
    }
}
