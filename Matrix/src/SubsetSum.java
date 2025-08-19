/*
Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a subset of the given array whose sum is equal to the given sum.
Examples:
    Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
    Output: True
    Explanation: There is a subset (4, 5) with sum 9.
    Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
    Output: False
    Explanation: There is no subset that add up to 30.
*/
public class SubsetSum {

    // Function to check if subset with given sum exists
    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        // dp[i][j] => whether sum j can be formed using first i elements
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: sum 0 is always possible with empty set
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Either include arr[i-1] or exclude it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    // Can't include, so only option is exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        System.out.println(isSubsetSum(arr1, sum1));  // true

        int[] arr2 = {3, 34, 4, 12, 5, 2};
        int sum2 = 30;
        System.out.println(isSubsetSum(arr2, sum2));  // false
    }
}