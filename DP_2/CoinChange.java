import java.util.*;

class TUF {
    static long countWaysToMakeChange(int[] arr, int n, int T) {

        long dp[][] = new long[n][T + 1];

        // Initializing base condition
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][T];
    }

    public static void main(String args[]) {

        int arr[] = { 1, 2, 3 };
        int target = 4;

        int n = arr.length;

        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n,
                target));
    }
}

// Time Complexity: O(N*T)

// Reason: There are two nested loops

// Space Complexity: O(N*T)

// Reason: We are using an external array of size ‘N*T’. Stack Space is eliminated.