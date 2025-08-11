/*

Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet.
Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:

Each student gets exactly one packet.
The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized.
Examples:

Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3
Output: 2
Explanation: If we distribute chocolate packets {3, 2, 4}, we will get the minimum difference, that is 2.

Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 5
Output: 7
Explanation: If we distribute chocolate packets {3, 2, 4, 9, 7}, we will get the minimum difference, that is 9 - 2 = 7.

Key Insight:
If packets are sorted, the best distribution will always be in a contiguous block of size m.

Algorithm:

Sort arr in ascending order.

Use a sliding window of size m:

For every i from 0 to n - m:

Find arr[i + m - 1] - arr[i]

Keep track of the minimum difference.

Return that minimum difference.
 */


import java.util.Arrays;

public class ChocolateDistribution {

    static int findMinDiff(int[] arr, int m) {
        if (m == 0 || arr.length == 0) return 0;
        if (m > arr.length) return -1; // Not enough packets

        Arrays.sort(arr); // Step 1: Sort packets
        int minDiff = Integer.MAX_VALUE;

        // Step 2: Sliding window
        for (int i = 0; i + m - 1 < arr.length; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println("Minimum difference: " + findMinDiff(arr, m));
    }
}
