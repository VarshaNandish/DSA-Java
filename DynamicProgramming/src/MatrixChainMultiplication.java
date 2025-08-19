/*
Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum. When two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed is m*n*p.
Examples:
    Input: arr[] = [2, 1, 3, 4]
    Output: 20
    Explanation: There are 3 matrices of dimensions 2x1, 1x3, and 3x4,
    Let the input 3 matrices be M1, M2, and M3. There are two ways to multiply ((M1 x M2) x M3) and (M1 x (M2 x M3)),
    Please note that the result of M1 x M2 is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix.
    ((M1 x M2) x M3)  requires (2 x 1 x 3)  +  (2 x 3 x 4) = 30
    (M1 x (M2 x M3))  requires (1 x 3 x 4) +  (2 x 1 x 4) = 20
    The minimum of these two is 20.
    Input: arr[] = [1, 2, 3, 4, 3]
    Output: 30
    Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3. Let the input 4 matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1M2)M3)M4. The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30
  Input: arr[] = [3, 4]
    Output: 0
    Explanation: As there is only one matrix so, there is no cost of multiplication.
Problem: Given arr[] of length n, matrices are M1 = arr[0]×arr[1], M2 = arr[1]×arr[2], …, M_{n-1} = arr[n-2]×arr[n-1]. Find the minimum number of scalar multiplications to multiply the whole chain M1 × M2 × … × M_{n-1}.
Key idea (divide & conquer + memoization):
Let MCM(i, j) be the minimum cost to multiply matrices Mi through Mj (1-based indexing on matrices).
If i == j (only one matrix), cost = 0.
Otherwise try every possible split k (i ≤ k < j) that partitions the chain into two parts:
left cost = MCM(i, k)
right cost = MCM(k+1, j)
cost to multiply the two resulting matrices = arr[i-1] * arr[k] * arr[j]
The recurrence:
*/
class MatrixChainMultiplication {

    static int MCM(int arr[], int i, int j, int dp[][]) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j]; // use memo

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = MCM(arr, i, k, dp)
                    + MCM(arr, k + 1, j, dp)
                    + arr[i - 1] * arr[k] * arr[j];

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        int n = arr.length;

        int dp[][] = new int[n][n];
        for (int row[] : dp) java.util.Arrays.fill(row, -1);

        System.out.println("Minimum multiplications = " + MCM(arr, 1, n - 1, dp));
    }
}
