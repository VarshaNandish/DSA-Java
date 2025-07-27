/*
Given an array arr[] of n integers, construct a product array res[] (of the same size) such that res[i] is equal to the product of all the elements of arr[] except arr[i].

Example:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation:

For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
 */

public class ProductArrayExceptSelf {

    public static int[] productArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Step 1: Build prefix product
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        // Step 2: Build suffix product
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        // Step 3: Multiply prefix and suffix to get result
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res = productArray(arr);

        for (int val : res)
            System.out.print(val + " ");
    }
}

