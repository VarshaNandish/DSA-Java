/*
Given an array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target.
This is a variation of the 2Sum problem.
 */


import java.util.Arrays;

public class TwoSum {

    static boolean twoSum(int[] arr, int target) {

        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;

        while(left<right) {
            int sum = arr[left] + arr[right];

            if (sum == target)
                return true;
                else if (sum<target)
                    left++;
                else
                    right--;

        }
        return false;

    }
    public static void main(String[] args){
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSum(arr, target)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
