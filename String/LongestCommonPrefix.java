class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        
        String prefix = strs[0];
        for (String s : strs){
            int i = 0; 
            while (i < Math.min(prefix.length(), s.length()) && prefix.charAt(i) == s.charAt(i)){
                i++;
            }
            prefix = s.substring(0, i);
        }
        return prefix;
    }
}

// Time complexity: O(N * C);
// Space complexity: O(1)