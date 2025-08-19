/*
Given an array of distinct integers arr[] and an integer target, the task is to find a list of all unique combinations of array where the sum of chosen element is equal to target.

Note: The same number may be chosen from array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Examples:

    Input: arr[] = [2, 4, 6, 8], target = 8
    Output: [[2, 2, 2, 2],
                    [2, 2, 4],
                    [2, 6],
                    [4, 4],
                    [8]]

    Input: arr[] = [2, 7, 6, 5], target = 16
    Output: [[2, 2, 2, 2, 2, 2, 2, 2],
                    [2, 2, 2, 2, 2, 6],
                    [2, 2, 2, 5, 5],
                    [2, 2, 5, 7],
                    [2, 2, 6, 6],
                    [2, 7, 7],
                    [5, 5, 6]]
Problem Restatement
We are given:
An array arr[] of distinct positive integers.
A target sum.
We must return all unique combinations of numbers where the chosen numbers sum up to target.
Each number can be used unlimited times.
Combinations must be unique (order doesn’t matter, i.e., [2,6] and [6,2] are considered same).
Algorithm (Backtracking Approach)
We use DFS + Backtracking:
1. Sort the array (optional but helps in structured output & pruning).
2. Define a recursive function:
*/
import java.util.*;

public class CombinationSum {

    static void solve(int[] arr, int target, int index,
                      List<Integer> current, List<List<Integer>> result) {
        // Base case: target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Base case: invalid path
        if (target < 0 || index == arr.length) return;

        // 1. Pick current element (arr[index])
        current.add(arr[index]);
        solve(arr, target - arr[index], index, current, result);
        current.remove(current.size() - 1); // backtrack

        // 2. Skip current element and move forward
        solve(arr, target, index + 1, current, result);
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // optional
        solve(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8};
        int target = 8;

        List<List<Integer>> ans = combinationSum(arr, target);
        System.out.println(ans);
    }
}