/*
Given an array of integers, the task is to find the length of the longest subsequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
Examples:
    Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
    Output: 6
    Explanation: The consecutive numbers here are from 1 to 6. These 6 numbers form the longest consecutive subsequence [2, 6, 1, 4, 5, 3].
    Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
    Output: 4
    Explanation: The subsequence [1, 3, 4, 2] is the longest subsequence of consecutive elements
    Input: arr[] = [36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42]
    Output: 5
    Explanation: The subsequence [36, 35, 33, 34, 32] is the longest subsequence of consecutive elements.
Optimal Approach (Using HashSet)
Idea:
We can achieve O(n) using a HashSet.
Insert all elements into a HashSet → O(n).
Only start counting if the current number is the start of a sequence (meaning num - 1 is not in the set).
From each start number, check how far the sequence continues (num + 1, num + 2, …) and update the max length.
Why better?
No sorting needed.
O(n) on average due to HashSet lookups.
Algorithm
1. Put all elements into a HashSet.
2. For each element num:
Check if num - 1 is not in the set (meaning num is the smallest number in its sequence).
If yes:
Initialize length = 1
While num + length is in set, increment length.
Update maxLength.
3. Return maxLength.
Time Complexity: O(n) (average)
Space Complexity: O(n) for HashSet
*/
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0; // Edge case: empty array

        // Step 1: Add all elements to a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: Iterate through each element
        for (int num : set) {
            // Only start counting if 'num' is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                // Step 3: Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                // Step 4: Update maxLength
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(findLongestConsecutive(arr1)); // Output: 6

        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(findLongestConsecutive(arr2)); // Output: 4

        int[] arr3 = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println(findLongestConsecutive(arr3)); // Output: 5
    }
}
