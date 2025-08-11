/*

Given a sorted and rotated array arr[] of n distinct elements, the task is to find the index of given key in the array.
If the key is not present in the array, return -1.

Examples:

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is present at index 8 in arr[].

Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: 6 is not present in arr[].

Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.

 */

public class SearchRotatedArray {

    // Function to search key in rotated sorted array
    public static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoid overflow

            if (arr[mid] == key) {
                return mid; // Found the key
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }
            // Else, right half must be sorted
            else {
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }

        return -1; // Not found
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(search(arr1, 3)); // Output: 8

        int[] arr2 = {3, 5, 1, 2};
        System.out.println(search(arr2, 6)); // Output: -1

        int[] arr3 = {33, 42, 72, 99};
        System.out.println(search(arr3, 42)); // Output: 1
    }
}
