/*
Given a sorted array of distinct elements arr[] of size n that is rotated at some unknown point,
the task is to find the minimum element in it.

Examples:

    Input: arr[] = [5, 6, 1, 2, 3, 4]
    Output: 1
    Explanation: 1 is the minimum element present in the array.

    Input: arr[] = [3, 1, 2]
    Output: 1
    Explanation: 1 is the minimum element present in the array.

    Input: arr[] = [4, 2, 3]
    Output: 2
    Explanation: 2 is the only minimum element in the array.
 */

public class MinInRotatedArray {

    public static int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // If array is not rotated
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid element is the minimum
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            // Check if mid+1 is the minimum
            if (mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // Decide which side to search
            if (arr[mid] >= arr[low]) {
                // Minimum is in right half
                low = mid + 1;
            } else {
                // Minimum is in left half
                high = mid - 1;
            }
        }

        return -1; // This should never happen for a valid rotated sorted array
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 1, 2, 3, 4};
        int[] arr2 = {3, 1, 2};
        int[] arr3 = {4, 2, 3};

        System.out.println(findMin(arr1)); // 1
        System.out.println(findMin(arr2)); // 1
        System.out.println(findMin(arr3)); // 2
    }
}
