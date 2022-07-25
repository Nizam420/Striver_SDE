// import java.util.*;
class Solution {
    public static int f(int i, int j, int[] arr, int[][] dp){
        int min = Integer.MAX_VALUE;
        if (i == j){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        for (int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + f(i, k, arr, dp) + f(k + 1, j, arr, dp);
            if (steps < min){
                min = steps;
            }
        }
        return dp[i][j] = min;
    }
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here
       
        int[][] dp = new int[N][N];
        for (int i = 1; i < N; i++){
            dp[i][i] = 0;
        }
        for (int i = N - 1; i >= 1; i--){
            for (int j = i + 1;j < N; j++){
                 int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                if (steps < min){
                    min = steps;
            }
        }
                 dp[i][j] = min;
            }
        }
        return dp[1][N-1];
	}
}

// Time complexity: O(N^3)
// Space complexity: O(N^2)