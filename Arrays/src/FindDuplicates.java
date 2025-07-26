
/*
Given an array arr[] of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times. The task is to find the repeating numbers.

Note: The repeating element should be printed only once.

Example:

Input: n = 7, arr[] = [1, 2, 3, 6, 3, 6, 1]
Output: 1, 3, 6
Explanation: The numbers 1 , 3 and 6 appears more than once in the array.

Input : n = 5, arr[] = [1, 2, 3, 4 ,3]
Output: 3
Explanation: The number 3 appears more than once in the array.
 */
import java.util.HashSet;

public class FindDuplicates {

    public static void printDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                duplicates.add(num);  // only added once
            } else {
                seen.add(num);
            }
        }

        // Print duplicates
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.print("Duplicates: ");
            for (int num : duplicates) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 3, 6, 1};
        int[] arr2 = {1, 2, 3, 4, 3};
        int[] arr3 = {0, 1, 2, 3};

        printDuplicates(arr1); // Output: 1 3 6
        printDuplicates(arr2); // Output: 3
        printDuplicates(arr3); // Output: No duplicates found
    }
}
