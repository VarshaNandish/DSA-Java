/*
Given a 2D matrix mat[][], compute its transpose. The transpose of a matrix is formed by converting all rows of mat[][] into columns and all columns into rows.

Example:

    Input: mat[][] = [[1, 1, 1, 1],
                                [2, 2, 2, 2],
                                [3, 3, 3, 3],
                               [4, 4, 4, 4]]
    Output: [[1, 2, 3 ,4],
                    [1, 2, 3, 4],
                    [1, 2, 3, 4],
                   [1, 2, 3, 4]]
    Explanation:  The output is the transpose of the input matrix, where each row becomes a column. This rearranges the data so that vertical patterns in the original matrix become horizontal in the result.

    Input: mat[][] = [[1, 2],
                              [9, -2]]
    Output: [[1, 9],
                 [2, -2]]
    Explanation:  The output is the transpose of the input matrix, where each row becomes a column. This rearranges the data so that vertical patterns in the original matrix become horizontal in the result.
*/
public class MatrixTranspose {
    public static int[][] transpose(int[][] mat) {
        int m = mat.length;        // number of rows
        int n = mat[0].length;     // number of columns

        int[][] trans = new int[n][m]; // transpose matrix size n x m

        // Fill transpose
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = mat[i][j];
            }
        }
        return trans;
    }

    // Utility to print matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        int[][] result1 = transpose(mat1);
        System.out.println("Transpose of Matrix 1:");
        printMatrix(result1);

        int[][] mat2 = {
                {1, 2},
                {9, -2}
        };

        int[][] result2 = transpose(mat2);
        System.out.println("Transpose of Matrix 2:");
        printMatrix(result2);
    }
}
