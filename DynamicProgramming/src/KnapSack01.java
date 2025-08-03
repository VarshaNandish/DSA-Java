/*
Given n items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.

Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

Input:  W = 4, profit[] = [1, 2, 3], weight[] = [4, 5, 1]
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: W = 3, profit[] = [1, 2, 3], weight[] = [4, 5, 6]
Output: 0

For each item i (0-based index), and for every capacity w from 0 to W, we have two choices:

Include item i (if weight[i] ≤ w)
Profit becomes: profit[i] + f(i-1, w - weight[i])

Exclude item i
Profit remains: f(i-1, w)

We take the maximum of these two choices:
f(i, w) = max(
    profit[i] + f(i-1, w - weight[i]),  // include
    f(i-1, w)                           // exclude
)

 */

import java.util.Arrays;

public class KnapSack01 {

    // Recursive function with memoization
    static int knapsack(int W, int[] weight, int[] profit, int n, int[][] memo) {
        // Base Case: No items or no capacity left
        if (n == 0 || W == 0)
            return 0;

        // If already computed
        if (memo[n][W] != -1)
            return memo[n][W];

        // If current item's weight is more than capacity, skip it
        if (weight[n - 1] > W) {
            memo[n][W] = knapsack(W, weight, profit, n - 1, memo);
        } else {
            // Take max of including or excluding the current item
            int include = profit[n - 1] + knapsack(W - weight[n - 1], weight, profit, n - 1, memo);
            int exclude = knapsack(W, weight, profit, n - 1, memo);
            memo[n][W] = Math.max(include, exclude);
        }

        return memo[n][W];
    }

    // Wrapper function
    public static int getMaxProfit(int W, int[] profit, int[] weight) {
        int n = profit.length;
        int[][] memo = new int[n + 1][W + 1];

        // Initialize memo with -1
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return knapsack(W, weight, profit, n, memo);
    }

    // Main method
    public static void main(String[] args) {
        int W1 = 4;
        int[] profit1 = {1, 2, 3};
        int[] weight1 = {4, 5, 1};
        System.out.println("Max Profit = " + getMaxProfit(W1, profit1, weight1));  // Output: 3

        int W2 = 3;
        int[] profit2 = {1, 2, 3};
        int[] weight2 = {4, 5, 6};
        System.out.println("Max Profit = " + getMaxProfit(W2, profit2, weight2));  // Output: 0
    }
}
