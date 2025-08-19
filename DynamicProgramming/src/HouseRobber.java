/*
There are n houses built in a line, each of which contains some money in it. A robber wants to steal money from these houses, but he can’t steal from two adjacent houses. The task is to find the maximum amount of money which can be stolen
Examples:
    Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
    Output: 19
    Explanation: The thief will steal from house 1, 3, 5 and 7, total money = 6 + 1 + 8 + 4 = 19.
    Input: hval[] = {5, 3, 4, 11, 2}
    Output: 16
    Explanation: Thief will steal from house 1 and 4, total money = 5 + 11 = 16.
Problem Restatement:
You have n houses in a line.
Each house i has some money hval[i].
If the robber steals from house i, they cannot steal from house i-1 or house i+1 (no two adjacent houses).
Find the maximum money that can be stolen.
Intuition:
At each house i, the robber has two choices:
1. Rob house i → then they cannot rob i-1, so they add hval[i] + dp[i-2]
2. Skip house i → then they take the result from dp[i-1]
So the relation is:
dp[i]=max(dp[i−1],hval[i]+dp[i−2])

Algorithm (DP approach):
1. Base cases:
If only 1 house: answer = hval[0]
If 2 houses: answer = max(hval[0], hval[1])
2. Build dp[]:
dp[i] = max money robbed considering up to house i
3. Return dp[n-1]
*/
public class HouseRobber {

    // Function to return max stolen value
    static int rob(int[] hval) {
        int n = hval.length;

        if (n == 0) return 0;
        if (n == 1) return hval[0];

        // dp[i] stores max money till house i
        int[] dp = new int[n];

        // Base cases
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        // Fill dp
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], hval[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] hval1 = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(rob(hval1));  // 19

        int[] hval2 = {5, 3, 4, 11, 2};
        System.out.println(rob(hval2));  // 16
    }
}