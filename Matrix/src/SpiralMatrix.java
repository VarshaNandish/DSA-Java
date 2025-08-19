/*
Given a matrix mat[][] of size m x n, the task is to print all elements of the matrix in spiral form.
Examples:
    Input: mat[][] = [[1,   2,   3,   4],
                               [5,    6,   7,   8],
                            [9,   10,  11,  12],
                          [13,  14,  15,  16]]
    Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
     Input: mat[][]= [[1,   2,   3,   4,  5,   6],
                             [7,   8,   9,  10,  11,  12],
                         [13,  14,  15, 16,  17,  18]]
    Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
Problem Summary
Given an m x n matrix, print its elements in spiral order (layer by layer clockwise).
Naive Approach
Use recursion to peel off the first row, last column, last row, and first column in each recursive call.
Not optimal, as recursion may cause extra space usage.
Time Complexity: O(m×n)O(m \times n)O(m×n)
Space Complexity: O(m×n)O(m \times n)O(m×n) (due to recursive stack)
Optimal Iterative Approach (Standard)
Idea:
Maintain four boundaries:
top (starting row index)
bottom (ending row index)
left (starting column index)
right (ending column index)
Then traverse:
1. Left → Right (along top row), then increment top.
2. Top → Bottom (along right column), then decrement right.
3. Right → Left (along bottom row), then decrement bottom.
4. Bottom → Top (along left column), then increment left.
Repeat until all elements are visited.
*/
import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;

        int top = 0;
        int bottom = mat.length - 1;
        int left = 0;
        int right = mat[0].length - 1;

        while (top <= bottom && left <= right) {
            // Step 1: Traverse from Left to Right
            for (int col = left; col <= right; col++) {
                result.add(mat[top][col]);
            }
            top++; // Move top boundary down

            // Step 2: Traverse from Top to Bottom
            for (int row = top; row <= bottom; row++) {
                result.add(mat[row][right]);
            }
            right--; // Move right boundary left

            // Step 3: Traverse from Right to Left (only if rows remain)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(mat[bottom][col]);
                }
                bottom--; // Move bottom boundary up
            }

            // Step 4: Traverse from Bottom to Top (only if cols remain)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(mat[row][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] mat2 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        System.out.println(spiralOrder(mat1)); // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        System.out.println(spiralOrder(mat2)); // [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
    }
}