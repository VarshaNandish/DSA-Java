/*
Given an integer array of coins[] of size n representing different types of denominations and an integer sum, the task is to count all combinations of coins to make a given value sum.

Note: Assume that you have an infinite supply of each type of coin.

Examples:

    Input: sum = 4, coins[] = [1, 2, 3]
    Output: 4
    Explanation: There are four solutions: [1, 1, 1, 1], [1, 1, 2], [2, 2] and [1, 3]

    Input: sum = 10, coins[] = [2, 5, 3, 6]
    Output: 5
    Explanation: There are five solutions:
    [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5]

    Input: sum = 10, coins[] = [10]
    Output: 1
    Explanation: The only is to pick 1 coin of value 10.

    Input: sum = 5, coins[] = [4]
    Output: 0
    Explanation:  We cannot make sum 5 with the given coins

    Approach: Dynamic Programming (Bottom-Up)
We’ll use a 1D DP array of size sum + 1 where:

dp[i] = number of ways to make sum i

Initialize dp[0] = 1 → Only one way to make sum 0 (pick no coins)
 */
public class CoinChangeSum {

    public static int countWaysToMakeSum(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;
        System.out.println("Ways to make " + sum1 + ": " + countWaysToMakeSum(coins1, sum1)); // Output: 4

        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;
        System.out.println("Ways to make " + sum2 + ": " + countWaysToMakeSum(coins2, sum2)); // Output: 5

        int[] coins3 = {10};
        int sum3 = 10;
        System.out.println("Ways to make " + sum3 + ": " + countWaysToMakeSum(coins3, sum3)); // Output: 1

        int[] coins4 = {4};
        int sum4 = 5;
        System.out.println("Ways to make " + sum4 + ": " + countWaysToMakeSum(coins4, sum4)); // Output: 0
    }
}
