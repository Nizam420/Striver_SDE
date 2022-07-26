import java.util.*;

class TUF {

    static int minSumPath(int n, int m, int[][] matrix) {

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = matrix[i][j];
                else {

                    int up = matrix[i][j];
                    if (i > 0)
                        up += dp[i - 1][j];
                    else
                        up += (int) Math.pow(10, 9);

                    int left = matrix[i][j];
                    if (j > 0)
                        left += dp[i][j - 1];
                    else
                        left += (int) Math.pow(10, 9);

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n - 1][m - 1];

    }

    public static void main(String args[]) {

        int matrix[][] = { { 5, 9, 6 }, { 11, 5, 2 } };

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(minSumPath(n, m, matrix));
    }
}

// Time Complexity: O(N*M)

// Reason: There are two nested loops

// Space Complexity: O(N*M)

// Reason: We are using an external array of size ‘N*M’’.