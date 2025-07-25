/*
Given an array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target.
This is a variation of the 2Sum problem.
 */
public class TwoSumNaive {

    static boolean twoSum(int[] arr, int target){
        int n = arr.length;

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (arr[i]+arr[j]==target) {
                    return true;
                }
            }
        }
        return false;

    }
    public static void main (String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }

}
