import java.util.*;
public class EggDroping {
    static int[][] dp;
    
    static int eggDrop(int n, int k) 
	{
	    // Initialize dp array with -1; Rows represents number of eggs. 
	    // And columns represents number of floors.
	    dp = new int[n+1][k+1];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
	    
	    return solveEggDrop(n, k);
	    
	}
	
	static int solveEggDrop(int n, int k) {
	    // Avoiding re-computation by using dp memorization approach
	    if(dp[n][k] != -1) {
	        return dp[n][k];
	    }
	    
	    // Base case 1. If floors are 0 or 1 then it takes same number of moves to find the critical floor.
	    if(k == 0 || k == 1) {
	        return k;
	    }
	    
	    // Base case 2. If we have only 1 egg, then worst case it will take k moves to find the critical floor.
	    if(n == 1) {
	        return k;
	    }
	    
	    int min = Integer.MAX_VALUE, i, v1, v2, val;
	    
	    // Start with each floor and check egg break and survives condtions. min of max is the answer for that floor.
	    for(i=1; i<=k; i++) {
	        v1 = solveEggDrop(n - 1, i - 1); // Egg Breaks
	        v2 = solveEggDrop(n, k - i); // Egg Survives
	        val = Math.max(v1, v2);
	        min = Math.min(min, val);
	    }
	    dp[n][k] = min + 1;
	    return dp[n][k];
	}
}

// Expected Time Complexity : O(N*(K^2))
// Expected Auxiliary Space: O(N*K)