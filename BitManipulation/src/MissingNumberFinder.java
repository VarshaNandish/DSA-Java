/*
Given an array arr[] of size n-1 with distinct integers in the range of [1, n]. This array represents a permutation of the integers from 1 to n with one element missing. Find the missing element in the array.

Examples:

    Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
    Output: 6
    Explanation: All the numbers from 1 to 8 are present except 6.

    Input: arr[] = [1, 2, 3, 5]
    Output: 4
    Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4
*/

public class MissingNumberFinder {

    // Function to find the missing number
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // Total numbers including the missing one

        // Using long to avoid overflow for large n
        long expectedSum = (long) n * (n + 1) / 2;

        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 2, 4, 5, 3, 7, 1};
        int[] arr2 = {1, 2, 3, 5};

        System.out.println("Missing number: " + findMissingNumber(arr1)); // Output: 6
        System.out.println("Missing number: " + findMissingNumber(arr2)); // Output: 4
    }
}