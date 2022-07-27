import java.util.*;

class Solution {

    public static int palindromePartitioning(String str) {
        // Write your code here
        int[][] dp = new int[str.length()][str.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return findMinCuts(str, 0, str.length() - 1, dp);
    }

    static int findMinCuts(String s, int i, int j, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];

        if (i >= j || isPalindrome(s, i, j)) {
            dp[i][j] = 0;
            return 0;
        }

        int minCuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cuts = 1 + findMinCuts(s, i, k, dp) + findMinCuts(s, k + 1, j, dp);
            minCuts = Math.min(minCuts, cuts);
        }

        dp[i][j] = minCuts;
        return minCuts;
    }

    static boolean isPalindrome(String s, int i, int j) {
        for (int x = i; x <= (i + j) / 2; x++) {
            if (s.charAt(x) != s.charAt(j - x + i))
                return false;
        }

        return true;
    }
}

// Expected Time Complexity: O(n*n) [n is the length of the string str]
// Expected Auxiliary Space: O(n*n)