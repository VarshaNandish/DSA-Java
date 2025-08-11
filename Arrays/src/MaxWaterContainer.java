/*

Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines,
find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Examples :

Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base = 2. Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6.

Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are distance 4 apart. So the size of the base = 4. Height of container = min(5, 3) = 3. So total area = 4 * 3 = 12.

Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
Output: 25
Explanation: 8 and 5 are 5 distance apart. So the size of the base = 5. Height of container = min(8, 5) = 5. So, total area = 5 * 5 = 25.
 */

public class MaxWaterContainer {

    public static int maxArea(int[] height) {
        int left = 0;                    // left pointer
        int right = height.length - 1;   // right pointer
        int maxArea = 0;

        while (left < right) {
            // Width is the distance between pointers
            int width = right - left;

            // Height is min of the two vertical lines
            int minHeight = Math.min(height[left], height[right]);

            // Calculate area
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 4, 3};
        System.out.println(maxArea(arr1)); // Output: 6

        int[] arr2 = {3, 1, 2, 4, 5};
        System.out.println(maxArea(arr2)); // Output: 12

        int[] arr3 = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxArea(arr3)); // Output: 25
    }
}

