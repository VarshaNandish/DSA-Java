/*
Given an array arr[] consisting of positive, negative, and zero values, find the maximum product that can be obtained from any contiguous subarray of arr[].

Examples:

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.

Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.

Input: arr[] = [2, 3, 4]
Output: 24
Explanation: For an array with all positive elements, the result is product of all elements.
 */


// Java program to find the maximum product subarray
public class MaxProductSubarray {

    // Utility method to return max of 3 integers
    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Utility method to return min of 3 integers
    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Method to calculate the maximum product subarray
    static int maxProduct(int[] arr) {
        int n = arr.length;

        // Initialize current max, min, and result with the first element
        int currMax = arr[0];  // Maximum product ending at current index
        int currMin = arr[0];  // Minimum product ending at current index
        int maxProd = arr[0];  // Overall maximum product

        // Traverse from the second element
        for (int i = 1; i < n; i++) {

            // Store previous currMax before updating it
            int tempMax = max(arr[i], arr[i] * currMax, arr[i] * currMin);

            // Update currMin (could flip sign due to negative value)
            currMin = min(arr[i], arr[i] * currMax, arr[i] * currMin);

            // Update currMax with the temporary value
            currMax = tempMax;

            // Update global max product
            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr1 = { -2, 6, -3, -10, 0, 2 };
        int[] arr2 = { -1, -3, -10, 0, 6 };
        int[] arr3 = { 2, 3, 4 };
        int[] arr4 = { -2, 0, -1 };

        System.out.println("Max Product (arr1): " + maxProduct(arr1)); // Output: 180
        System.out.println("Max Product (arr2): " + maxProduct(arr2)); // Output: 30
        System.out.println("Max Product (arr3): " + maxProduct(arr3)); // Output: 24
        System.out.println("Max Product (arr4): " + maxProduct(arr4)); // Output: 0
    }
}
