// import java.util.*;

class TUF {
    static int knapsack(int[] wt, int[] val, int n, int W) {

        int dp[][] = new int[n][W + 1];

        // Base Condition

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTaken = 0 + dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap)
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W];
    }

    public static void main(String args[]) {

        int wt[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int W = 5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "
                + knapsack(wt, val, n, W));
    }
}

// Time Complexity: O(N*W)

// Reason: There are two nested loops

// Space Complexity: O(N*W)

// Reason: We are using an external array of size ‘N*W’. Stack Space is eliminated.