import java.util.*;
class Solution{
    void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> subset){
        if (ind == N){
            subset.add(sum);
            return;
        }
        func(ind + 1, sum + arr.get(ind), arr, N, subset);
        func(ind + 1, sum, arr, N, subset);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> subset = new ArrayList<>();
        func(0, 0, arr, N, subset);
        Collections.sort(subset);
        return subset;
    }
}

// Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it. So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

// Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.