/*
Trapping Rainwater Problem states that given an array of n non-negative integers arr[] representing an elevation map where the width of
each bar is 1, compute how much water it can trap after rain.

Trapping Rainwater Problem
Trapping Rainwater Problem
Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
Output: 10
Explanation: The expected rainwater to be trapped is shown in the above image.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: We trap 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides

Observations
The basic intuition of the problem is as follows:

An element of the array can store water if there are higher bars on the left and the right.
The amount of water to be stored in every position can be found by finding the heights of the higher bars on the left and right sides.
The total amount of water stored is the summation of the water stored in each index.
No water can be filled if there is no boundary on both sides.

1. Problem Restatement
We have bars of different heights (array elements).
Water can only be trapped between two taller bars, because:

Water will flow away if either side is open (no boundary).

The amount of water above a bar depends on the shorter boundary on either side.

2. Core Observation
For each index i:

Find leftMax[i] = tallest bar to the left (including itself).

Find rightMax[i] = tallest bar to the right (including itself).

Water trapped at i = min(leftMax[i], rightMax[i]) - height[i]
(only if this value is positive).
 */


public class TrappingRainWater {
    static int trap(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);

        int water = 0;
        for (int i = 0; i < n; i++)
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];

        return water;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        System.out.println(trap(arr)); // 10
    }
}
