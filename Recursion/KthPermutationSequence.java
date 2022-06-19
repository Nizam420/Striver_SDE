import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i < n; i++){
            fact = fact * i;
            num.add(i);
        }
        num.add(n);
        k = k - 1;
        String ans = "";
        while (true){
            ans = ans + num.get(k / fact);
            num.remove(k / fact);
            if (num.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        }
        return ans;
    }
}

// Time complexity: O(N! * N) +O(N! Log N!)

// Reason:  The recursion takes O(N!)  time because we generate every possible permutation and another O(N) 
//  time is required to make a deep copy and store every sequence in the data structure. Also, O(N! Log N!)  
//  time required to sort the data structure

// Space complexity: O(N) 

// Reason: Result stored in a vector, we are auxiliary space taken by recursion