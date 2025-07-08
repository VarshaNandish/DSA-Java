/*

Problem:

Given an array of integers and a target value, write a recursive function to check whether the target is present in the array. Return the index of the target if found, or -1 if not found.

Step-by-Step Explanation

Logic:

Base Case 1: If the index reaches the end of the array → return -1 (not found).
Base Case 2: If the current element matches the target → return the current index.
Recursive Step: Call the function again with the next index (index + 1).

Dry Run
Input: arr = {5, 8, 12, 20, 30}, target = 20, index = 0

Call

Check Result

recursiveSearch(arr, 0)
   5 == 20 → ❌
        recurse

recursiveSearch(arr, 1)
   8 == 20 → ❌
         recurse

recursiveSearch(arr, 2)
   12 == 20 → ❌
         recurse

recursiveSearch(arr, 3)
   20 == 20 → ✅
          return 3

Time Complexity
O(n) – visits each element once

Space Complexity
O(n) – due to recursion stack

*/



public class RecursiveArraySearch {

    // Recursive function to search for a target element
    public static int recursiveSearch(int[] arr, int target, int index) {

        // Base case: index goes out of bounds
        if (index == arr.length) {
            return -1;
        }

        // Base case: element found
        if (arr[index] == target) {
            return index;
        }

        // Recursive step: search in the rest of the array
        return recursiveSearch(arr, target, index + 1);
    }



    public static void main(String[] args) {

        int[] nums = {5, 8, 12, 20, 30, 45};
        int target = 20;

        int result = recursiveSearch(nums, target, 0);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in array.");

        }
    }
}
