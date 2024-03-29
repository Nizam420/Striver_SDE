import java.util.*;

class Solution {
    public static int cutRod(int price[], int N) {
        // Write your code here.
        int dp[][] = new int[N][N + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        for (int i = 0; i <= N; i++) {
            dp[0][i] = i * price[0];
        }

        for (int ind = 1; ind < N; ind++) {
            for (int length = 0; length <= N; length++) {

                int notTaken = 0 + dp[ind - 1][length];

                int taken = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= length)
                    taken = price[ind] + dp[ind][length - rodLength];

                dp[ind][length] = Math.max(notTaken, taken);
            }
        }

        return dp[N - 1][N];
    }
}

// Time Complexity: O(N*N)

// Reason: There are two nested loops

// Space Complexity: O(N*N)

// Reason: We are using an external array of size ‘N*(N+1)’. Stack Space is
// eliminated.