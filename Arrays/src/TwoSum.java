/*Given an array of integers nums and an integer target, return the index position of the two numbers such that they add up to target.
Each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 Example:
Input: [2, 7, II, 15]
Output: [0, 1]
Approach: Optimized Using HashMap
Algorithm:
Use a HashMap to store values (key = number, value = index).
        Iterate through the array:
        For each number nums[i], compute complement = target - nums[i].
        Check if complement is already in the map.
        If it is, return indices [map.get(complement), i].
        Else, store nums[i] and its index in the map.
        Time Complexity: O(n) — Single pass through the array.
        Space Complexity:O(n) — Storing elements in a HashMap.
        Step-by-Step Dry Run for Optimized Approach:
        Input: nums = [2, 7, 11, 15], target = 9
        Iteration 0:
        i = 0, nums[i] = 2, complement = 7
        map is empty → store 2:0
        Iteration 1:
        i = 1, nums[i] = 7, complement = 2
        2 is in map → return [0, 1]*/



import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store the number and its index

        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array

        for (int i = 0; i < nums.length; i++) {

            // Calculate the complement that would sum up to target

            int complement = target - nums[i];

            // If complement exists in map, we found the pair

            if (map.containsKey(complement)) {

                return new int[] {map.get(complement), i};

            }

            // Store the number with its index

            map.put(nums[i], i);

        }

        return new int[] {}; // As a fallback, in case no pair is found

    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

    }

}
