/*
Given a boolean matrix mat where each cell contains either 0 or 1, the task is to modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.

Examples:

    Input: [[1, 0],
               [0, 0]]
    Output: [[1, 1],
                  [1, 0]]

    Input: [[1, 0, 0, 1],
               [0, 0, 1, 0],
              [0, 0, 0, 0]]
    Output: [[1, 1, 1, 1],
                   [1, 1, 1, 1],
                  [1, 0, 1, 1]]
*/
public class BooleanMatrixModify {
    public static void modifyMatrix(int mat[][]) {
        int R = mat.length;
        int C = mat[0].length;

        // Step 1: Arrays to track rows and cols containing 1
        int[] row = new int[R];
        int[] col = new int[C];

        // Step 2: Mark rows and cols where 1 is found
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 3: Update matrix
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    // Utility function to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Driver
    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 0},
                {0, 0}
        };

        modifyMatrix(mat1);
        printMatrix(mat1);
        System.out.println();

        int[][] mat2 = {
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        modifyMatrix(mat2);
        printMatrix(mat2);
    }
}