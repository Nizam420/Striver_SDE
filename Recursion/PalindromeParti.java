import java.util.*;

class Solution {
    boolean isPalin(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public void f(int ind, String s, List<String> path, List<List<String>> ans) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalin(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                f(i + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        f(0, s, path, ans);
        return ans;
    }
}

// Time Complexity:

// O( (2^n) *k*(n/2) )

// Reason: O(2^n) to generate every substring

// and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.

// Space Complexity: O(k * x)

// Reason: The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).