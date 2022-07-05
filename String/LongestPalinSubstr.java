class Solution {
    int maxLen = 0;
    int startPos = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++){
            palin(s, i, i);
            palin(s, i, i+1);
        }
        return s.substring(startPos, startPos+maxLen);
    }
    public void palin(String s, int start, int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if (maxLen < end - start - 1){
            maxLen = end - start - 1;
            startPos = start + 1;
        }
    }
}

//Time complexity: O(N^2)
//Space complexity: O(1)