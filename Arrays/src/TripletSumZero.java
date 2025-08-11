/*
Given an array arr[], the task is to find all possible indices {i, j, k} of triplet {arr[i], arr[j], arr[k]}
such that their sum is equal to zero and all indices in a triplet should be distinct (i != j, j != k, k != i).
We need to return indices of a triplet in sorted order, i.e., i < j < k.

Examples :

Input: arr[] = {0, -1, 2, -3, 1}
Output: {{0, 1, 4}, {2, 3, 4}}
Explanation:  Two triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0

Input: arr[] = {1, -2, 1, 0, 5}
Output: {{0, 1, 2}}
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0

Input: arr[] = {2, 3, 1, 0, 5}
Output: {{}}
Explanation: There is no triplet with sum 0

 */


import java.util.*;

public class TripletSumZero {

    public static List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Store (value, originalIndex) pairs
        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(arr[i], i);
        }

        // Step 2: Sort by value
        Arrays.sort(nums, Comparator.comparingInt(p -> p.value));

        // Step 3: Iterate through each element
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i].value + nums[left].value + nums[right].value;

                if (sum == 0) {
                    // Store original indices in sorted order
                    List<Integer> triplet = Arrays.asList(nums[i].index, nums[left].index, nums[right].index);
                    Collections.sort(triplet);
                    result.add(triplet);

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // Helper class to store value and original index
    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        System.out.println(findTriplets(arr1)); // Expected: [[0, 1, 4], [2, 3, 4]]

        int[] arr2 = {1, -2, 1, 0, 5};
        System.out.println(findTriplets(arr2)); // Expected: [[0, 1, 2]]

        int[] arr3 = {2, 3, 1, 0, 5};
        System.out.println(findTriplets(arr3)); // Expected: []
    }
}
