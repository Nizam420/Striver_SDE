import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums){
            hs.add(num);
        }
        int ans = 0;
        for (int num : nums){
            if (!hs.contains(num-1)){
                int curNum = num;
                int curSt = 1;
                while (hs.contains(curNum + 1)){
                    curNum +=1;
                    curSt += 1;
                }
                ans = Math.max(ans, curSt);
            }
        }
        return ans;
    }
}

// Time Complexity: O(3N)

// Space Complexity: O(N)