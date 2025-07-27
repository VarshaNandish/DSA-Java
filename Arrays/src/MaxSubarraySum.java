/*
Given an integer array arr[], find the subarray (containing at least one element) which has the maximum possible sum, and return that sum.
Note: A subarray is a continuous part of an array.

Examples:

Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.

Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2.

Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
 */

public class MaxSubarraySum {

    public static int maxSubArray(int[] arr) {
        // Start both current and max sum with the first element
        int currentSum = arr[0];
        int maxSum = arr[0];

        // Traverse from second element onwards
        for (int i = 1; i < arr.length; i++) {

            // At each step, decide: take current element or add it to previous sum
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update global maximum if current is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        int[] arr2 = {-2, -4};
        int[] arr3 = {5, 4, 1, 7, 8};

        System.out.println("Max Sum (arr1): " + maxSubArray(arr1)); // 11
        System.out.println("Max Sum (arr2): " + maxSubArray(arr2)); // -2
        System.out.println("Max Sum (arr3): " + maxSubArray(arr3)); // 25
    }
}
